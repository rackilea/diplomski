import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LayoutExample1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LayoutExample1 frame = new LayoutExample1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LayoutExample1() {
        setTitle("Title of GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 1.0};
        gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblTag = new JLabel("Tag 1");
        GridBagConstraints gbc_lblTag = new GridBagConstraints();
        gbc_lblTag.insets = new Insets(0, 0, 0, 5);
        gbc_lblTag.anchor = GridBagConstraints.EAST;
        gbc_lblTag.gridx = 0;
        gbc_lblTag.gridy = 0;
        panel.add(lblTag, gbc_lblTag);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton btnConfirm = new JButton("Confirm");
        panel_1.add(btnConfirm);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JTextArea textArea = new JTextArea("I am a bot and I will tell you what I am doing to your systems!");
        textArea.setColumns(20);
        scrollPane.setViewportView(textArea);

        pack();
    }

}