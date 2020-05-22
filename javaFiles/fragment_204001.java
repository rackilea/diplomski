import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class JTextAreaExample {

    private JFrame frame;
    private static JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JTextAreaExample window = new JTextAreaExample();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public JTextAreaExample() {
        JTextAreaExample.textArea = new JTextArea();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(textArea, BorderLayout.CENTER);
        textArea.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "ctrlvpressed");
        textArea.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "ctrlvpressed");
        CustomPasteAction cpa = new CustomPasteAction("Custom Paste Action", null, "A custom paste action", KeyEvent.VK_V);
        textArea.getActionMap().put("ctrlvpressed", cpa);
    }

    public static final JTextArea getTextArea() {
        return textArea;
    }

}