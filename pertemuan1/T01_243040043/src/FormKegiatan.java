
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FormKegiatan {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormKegiatan::GUI);
    }

    private static void GUI() {
        JFrame frame = new JFrame("Form Pendaftaran Kegiatan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //1
        JTextField namaField = new JTextField(20);
        JTextField nimField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        JPanel identitasPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        identitasPanel.setBorder(BorderFactory.createTitledBorder("Identitas"));
        identitasPanel.add(new JLabel("Nama:"));
        identitasPanel.add(namaField);
        identitasPanel.add(new JLabel("NIM:"));
        identitasPanel.add(nimField);
        identitasPanel.add(new JLabel("Email:"));
        identitasPanel.add(emailField);

        //2
        String[] daftarKegiatan = {"Internship", "Panitia", "Sertifikasi", "Volunteer"};
        JComboBox<String> kegiatanCombo = new JComboBox<>(daftarKegiatan);

        JRadioButton pagiRadio = new JRadioButton("Pagi", true);
        JRadioButton siangRadio = new JRadioButton("Siang");
        JRadioButton soreRadio = new JRadioButton("Sore");
        ButtonGroup sesiGroup = new ButtonGroup();
        sesiGroup.add(pagiRadio);
        sesiGroup.add(siangRadio);
        sesiGroup.add(soreRadio);
        JPanel sesiPanel = new JPanel(new GridLayout(1, 3));
        sesiPanel.add(pagiRadio);
        sesiPanel.add(siangRadio);
        sesiPanel.add(soreRadio);

        JCheckBox konsumsiCheck = new JCheckBox("Konsumsi");
        JCheckBox sertifikatCheck = new JCheckBox("Sertifikat");
        JCheckBox notesCheck = new JCheckBox("Notes");
        JPanel kebutuhanPanel = new JPanel(new GridLayout(1, 3));
        kebutuhanPanel.add(konsumsiCheck);
        kebutuhanPanel.add(sertifikatCheck);
        kebutuhanPanel.add(notesCheck);

        JPanel kegiatanPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        kegiatanPanel.setBorder(BorderFactory.createTitledBorder("Pilihan Kegiatan"));
        kegiatanPanel.add(new JLabel("Jenis kegiatan:"));
        kegiatanPanel.add(kegiatanCombo);
        kegiatanPanel.add(new JLabel("Sesi:"));
        kegiatanPanel.add(sesiPanel);
        kegiatanPanel.add(new JLabel("Kebutuhan:"));
        kegiatanPanel.add(kebutuhanPanel);

        //3
        JTextArea catatanArea = new JTextArea(5, 20);
        catatanArea.setLineWrap(true);
        catatanArea.setWrapStyleWord(true);

        JPanel catatanPanel = new JPanel(new BorderLayout());
        catatanPanel.setBorder(BorderFactory.createTitledBorder("Catatan"));
        catatanPanel.add(new JScrollPane(catatanArea), BorderLayout.CENTER);

        //4
        JLabel statusLabel = new JLabel("Silakan isi formulir.");
        JButton daftarButton = new JButton("Daftar");
        daftarButton.addActionListener(event -> statusLabel.setText("Tombol ditekan."));

        JPanel tindakanPanel = new JPanel(new BorderLayout(8, 0));
        tindakanPanel.add(statusLabel, BorderLayout.CENTER);
        tindakanPanel.add(daftarButton, BorderLayout.EAST);

        //5
        JPanel atasPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        atasPanel.add(identitasPanel);
        atasPanel.add(kegiatanPanel);

        JPanel utamaPanel = new JPanel(new BorderLayout(10, 10));
        utamaPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        utamaPanel.add(atasPanel, BorderLayout.NORTH);
        utamaPanel.add(catatanPanel, BorderLayout.CENTER);
        utamaPanel.add(tindakanPanel, BorderLayout.SOUTH);

        frame.setContentPane(utamaPanel);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
