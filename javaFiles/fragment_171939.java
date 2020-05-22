import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {

    private JFrame frame;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Test window = new Test();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public Test() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox chA = new JCheckBox("text");
        chA.setFont(new Font("Adobe Arabic", Font.PLAIN, 14));
        frame.getContentPane().add(chA);

        JCheckBox chB = new JCheckBox("text");
        chB.setFont(new Font("Adobe Arabic", Font.PLAIN, 14));
        frame.getContentPane().add(chB);

        JCheckBox chckbx1 = new JCheckBox("text");
        chckbx1.setFont(new Font("Adobe Arabic", Font.PLAIN, 14));
        chckbx1.setEnabled(false);
        frame.getContentPane().add(chckbx1);

        JPanel panel = new JPanel();
        frame.add(panel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(200, 200));
        textArea = new JTextArea(5, 5);
        scrollPane.add(textArea);
        textArea.setColumns(6);
        panel.add(scrollPane);
        panel.setVisible(false);

        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == chA || e.getSource() == chB) {
                    chckbx1.setEnabled(true);
                }

                if (e.getSource() == chckbx1) {
                    panel.setVisible(true);
                    frame.repaint();
                }
            }
        };
        chA.addActionListener(al);
        chB.addActionListener(al);
        chckbx1.addActionListener(al);
    }

}