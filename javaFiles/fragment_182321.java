import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Sample extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Sample frame = new Sample();
                    frame.pack();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Sample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("New label");
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(2);

        textField_1 = new JTextField();
        panel_2.add(textField_1);
        textField_1.setColumns(2);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);

        JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
        panel_3.add(chckbxNewCheckBox);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);

        JButton btnNewButton = new JButton("New");
        panel_4.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New");
        panel_4.add(btnNewButton_1);

        JPanel flowPanel = new JPanel();
        flowPanel.add(panel_1);
        contentPane.add(flowPanel, BorderLayout.WEST);
        contentPane.add(new JPanel(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }

            @Override
            public Color getBackground() {
                return Color.lightGray;
            }

        }, BorderLayout.CENTER);
    }

}