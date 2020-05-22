import static java.awt.event.KeyEvent.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class KeyboardDispatcherDemo extends JFrame {

    /**
     * This class shows how to map numeric keypad keys.
     * It performs two conversions:
     * 1. lower-to-uppercase
     * 2. if numeric keypad 7-9 is typed, 1-3 appears and vice versa.
     * 
     * This is modified from the code at 
     * http://www.exampledepot.com/egs/java.awt/DispatchKey.html#comment-51807
     * which demoes the lower-to-upper conversion.
     * 
     * It doesn't yet handle modified numeric keypad keys.
     * 
     */
    public KeyboardDispatcherDemo() {

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
            new KeyEventDispatcher() {
                private char lastMappedKey;
                private final Map<Integer, Character> keyMap = 
                    new HashMap<Integer, Character>() { 
                {
                    put(VK_NUMPAD1, '7'); 
                    put(VK_NUMPAD2, '8'); 
                    put(VK_NUMPAD3, '9'); 
                    put(VK_NUMPAD7, '1'); 
                    put(VK_NUMPAD8, '2'); 
                    put(VK_NUMPAD9, '3'); 

                }};

                public boolean dispatchKeyEvent(KeyEvent e) {
                    System.out.println(String.format("INPUT: %s", e.toString()));
                    boolean dispatch = false;
                    switch (e.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        dispatch = dispatchKeyPressed(e);
                        break;
                    case KeyEvent.KEY_TYPED:
                        dispatch = dispatchKeyTyped(e);
                        break;
                    case KeyEvent.KEY_RELEASED: 
                        dispatch = dispatchKeyReleased(e);
                        break;
                    default:
                        throw new IllegalArgumentException();
                    }
                    System.out.println(String.format("OUTPUT: %s", e.toString()));
                    System.out.println();
                    return dispatch;
                }
                private boolean dispatchKeyPressed(KeyEvent e) {
                    char k = e.getKeyChar();
                    if (k != CHAR_UNDEFINED) {
                        if (Character.isLetter(k)) {
                            e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
                        } else if (e.getModifiers() == 0){
                            Character mapping = keyMap.get(e.getKeyCode());
                            if (mapping != null) {
                                e.setKeyChar(mapping);
                            }
                        }
                        // save the last mapping so that KEY_TYPED can use it.
                        // note we don't do this for modifier keys.
                        this.lastMappedKey = e.getKeyChar();
                    }
                    return false;
                }

                // KEY_TYPED events don't have keyCodes so we rely on the
                // lastMappedKey that was saved on KeyPressed.
                private boolean dispatchKeyTyped(KeyEvent e) {
                    char k = e.getKeyChar();
                    if (k != CHAR_UNDEFINED) {
                        e.setKeyChar(lastMappedKey);
                    }
                    return false;
                }
                private boolean dispatchKeyReleased(KeyEvent e) {
                    char k = e.getKeyChar();
                    if (k != CHAR_UNDEFINED) {
                        e.setKeyChar(lastMappedKey);
                        this.lastMappedKey=CHAR_UNDEFINED;
                    }
                    return false;

                }
            });




        setTitle("KeyboardDispatcherDemo");
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 153, 255));
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        JTextArea staticText = new JTextArea();
        staticText.setText("This demonstrates how to map numeric keypad keys.  It uppercases all letters and converts Numeric Keypad 1-3 to 7-9 and vice versa.  Try it.");
        staticText.setLineWrap(true);
        staticText.setWrapStyleWord(true);
        panel.add(staticText, BorderLayout.NORTH);
        staticText.setFocusable(false);

        JTextField textField = new JTextField();
        textField.setText("");
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(textField, BorderLayout.SOUTH);
        textField.setColumns(10);
        textField.setFocusable(true);


        setSize(getPreferredSize());

        setVisible(true);


    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new KeyboardDispatcherDemo();

    }

    @Override
    public Dimension getPreferredSize() {
        // TODO Auto-generated method stub
        return new Dimension(400,300);
    }

}