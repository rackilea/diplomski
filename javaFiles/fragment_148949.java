import java.awt.Toolkit;
import java.awt.event.ActionListener;    
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Foo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            repeatMessage("Hello", 2000);
            JOptionPane.showMessageDialog(null, "foo"); // starts the thread
        });

    }

    private static void repeatMessage(String text, int delay) {
        ActionListener listener = event -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay, listener).start();
    }
}