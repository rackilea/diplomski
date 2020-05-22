import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelTest {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();

        String text = "<html>/test</html>";

        label.setText(text);

        frame.add(label);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}