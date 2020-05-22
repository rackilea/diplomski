import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//http://stackoverflow.com/q/24800417/714968
public class KeyBindingTest3 {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame("KeyBinding Test");
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new MainPanel());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class MainPanel extends JPanel {
  public MainPanel() {
    super();
    //@see JTable constructor
    Set<KeyStroke> forwardKeys = new HashSet<KeyStroke>(1);
    forwardKeys.add(KeyStroke.getKeyStroke(
        KeyEvent.VK_TAB, InputEvent.CTRL_MASK));
    setFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

    Set<KeyStroke> backwardKeys = new HashSet<KeyStroke>(1);
    backwardKeys.add(KeyStroke.getKeyStroke(
        KeyEvent.VK_TAB, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
    setFocusTraversalKeys(
        KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, backwardKeys);

    setPreferredSize(new Dimension(200, 200));

    String aString = "aStr";
    getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), aString);
    getActionMap().put(aString, new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        System.out.println("a is typed");
      }
    });
    String tabString = "TAB";
    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), tabString);
    getActionMap().put(tabString, new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        System.out.println("tab is typed");
      }
    });
  }
}