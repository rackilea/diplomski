import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class JavaApplication1 {

    public static void main(String[] args) {
        new JavaApplication1();
    }

    public JavaApplication1() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(8, 8, 8, 8);

            JLabel label = new JLabel("Image placeholder") {
                // This is done only for demonstration purposes
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(128, 128);
                }
            };
            label.setBorder(new LineBorder(Color.DARK_GRAY));

            add(label, gbc);

            gbc.gridy++;
            gbc.fill = GridBagConstraints.BOTH;
            // This will cause the text area to occupy all the avalilable free space
            //gbc.weightx = 1;
            //gbc.weighty = 1;
            JTextArea ta = new JTextArea(10, 20);
            add(new JScrollPane(ta), gbc);

            JButton btn = new JButton("Run");
            gbc.gridy++;
            // Reset the constraints
            gbc.fill = GridBagConstraints.NONE;
            gbc.weightx = 0;
            gbc.weighty = 0;
            add(btn, gbc);
        }

    }
}