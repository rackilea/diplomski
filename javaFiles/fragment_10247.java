import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            // This is a space to force the buttons
            // to the right edge.
            // You might be able to play around with the constraints
            // for b1 to basically get the same affect
            add(new JLabel(), gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JLabel label = new JLabel("This is the title");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label, gbc);

            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(new JButton("B1"), gbc);
            gbc.gridx++;
            add(new JButton("B2"), gbc);
            gbc.gridx++;
            add(new JButton("B3"), gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 44);
        }

    }

}