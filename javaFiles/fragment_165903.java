import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** @see https://stackoverflow.com/a/29643591/230513 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JLabel("Test", JLabel.CENTER));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                new Test().display();
        });
    }
}