import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** @see https://stackoverflow.com/a/32016671/230513 */
public class HelloFrame {

    private void display() {
        JFrame f = new JFrame("HelloFrame");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Hello World!");
        f.add(new JLabel("Hello World! Hello World!"), JLabel.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new HelloFrame()::display);
    }
}