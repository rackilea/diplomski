import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestLayout {

    public static void main(String[] args) {
        JFrame frame = new Houdini();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setSize(250, 250);
        System.out.println(frame.getWidth());
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static class Houdini extends JFrame {

        private JButton one = new JButton("one");
        private JButton two = new JButton("two");
        private JButton three = new JButton("three");
        private JButton four = new JButton("four");
        private JButton five = new JButton("five");

        private GridBagConstraints gbc = new GridBagConstraints();
        private JPanel panel = new JPanel(new BorderLayout());

        public Houdini() {

            JPanel top = new JPanel(new BorderLayout());
            top.add(one);
            JPanel center = new JPanel(new GridLayout(0, 3));

            center.add(empty());
            center.add(two);
            center.add(empty());
            center.add(empty());
            center.add(empty());
            center.add(three);

            panel.add(top, BorderLayout.NORTH);
            panel.add(center);

            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            add(panel);

        }

        private JComponent empty() {
            JPanel panel = new JPanel();
            return panel;
        }
    }
}