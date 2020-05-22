import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class KeyBindActionDemo {

    public KeyBindActionDemo() {
        Action printHelloAction = new AbstractAction("Print") {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
            }
        };
        JPanel panel = new JPanel();
        InputMap im = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK), "printAction");
        ActionMap am = panel.getActionMap();
        am.put("printAction", printHelloAction);

        JButton button = new JButton(printHelloAction);
        button.setText("Print Hello");

        panel.add(button);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new KeyBindActionDemo();
            }
        });
    }
}