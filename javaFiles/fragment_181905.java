import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddAt {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel one = new JLabel("one");
        JLabel two = new JLabel("two");
        JLabel between = new JLabel("between");

        frame.add(panel);
        panel.add(one);
        panel.add(two);
        panel.add(between, 1);

        frame.pack();
        frame.setVisible(true);
    }
}