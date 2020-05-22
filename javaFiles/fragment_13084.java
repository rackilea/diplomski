import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyExample {

    private JPanel contentPane;

    private class KeyAction extends AbstractAction {

        private String keyState;
        private String keyValue;

        public KeyAction(String state, String value) {
            this.keyState = state;
            this.keyValue = value;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Value: " + keyValue + " State: " + keyState);
        }
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        KeyStroke keyStroke = null;

        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_CONTROL, InputEvent.CTRL_DOWN_MASK, false);
        inputMap.put(keyStroke, "pressedControl");
        contentPane.getActionMap().put("pressedControl", new KeyAction("pressed", "CONTROL"));

        keyStroke = KeyStroke.getKeyStroke("released CONTROL");
        inputMap.put(keyStroke, "releasedControl");
        contentPane.getActionMap().put("releasedControl", new KeyAction("released", "CONTROL"));

        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_SHIFT, InputEvent.SHIFT_DOWN_MASK, false);
        inputMap.put(keyStroke, "pressedShift");
        contentPane.getActionMap().put("pressedShift", new KeyAction("pressed", "SHIFT"));

        keyStroke = KeyStroke.getKeyStroke("released SHIFT");
        inputMap.put(keyStroke, "releasedShift");
        contentPane.getActionMap().put("releasedShift", new KeyAction("released", "SHIFT"));

        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ALT, InputEvent.ALT_DOWN_MASK, false);
        inputMap.put(keyStroke, "pressedAlt");
        contentPane.getActionMap().put("pressedAlt", new KeyAction("pressed", "ALT"));

        keyStroke = KeyStroke.getKeyStroke("released ALT");
        inputMap.put(keyStroke, "releasedAlt");
        contentPane.getActionMap().put("releasedAlt", new KeyAction("released", "ALT"));

        frame.setContentPane(contentPane);
        frame.setSize(300, 100);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new KeyExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}