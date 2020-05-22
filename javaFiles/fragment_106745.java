import java.awt.AWTKeyStroke;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class CheckBoxDemo {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(2, 2, 10, 10));

        frame.add(new JCheckBox("Bird"));
        frame.add(new JCheckBox("Cat"));
        frame.add(new JCheckBox("Dog"));
        frame.add(new JCheckBox("Rabbit"));

        Set<AWTKeyStroke> forwardKeys = frame.getFocusTraversalKeys(
                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
        Set<AWTKeyStroke> newForwardKeys = new HashSet<AWTKeyStroke>(forwardKeys);
        newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));
        frame.setFocusTraversalKeys(
                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, newForwardKeys);

        Set<AWTKeyStroke> backwardKeys = frame.getFocusTraversalKeys(
                KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS);
        Set<AWTKeyStroke> newBackKeys = new HashSet<AWTKeyStroke>(backwardKeys);
        newBackKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0));
        frame.setFocusTraversalKeys(
                KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, newBackKeys);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}