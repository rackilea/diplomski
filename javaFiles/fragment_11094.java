import java.awt.BorderLayout;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JMenubarAltTest extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    private KeyEventPostProcessor altPostprocessor;

    public JMenubarAltTest() {
        super();

        // Disable the ALT for the Mnemonic and put CTRL key instead:
        int[] ints = {java.awt.event.KeyEvent.CTRL_MASK};
        javax.swing.UIManager.put("Menu.shortcutKeys", ints);

        // Put the platform L&F, in my case I need this to work in Windows
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // Create a random menu with some random items
        javax.swing.JMenuBar jmb = new javax.swing.JMenuBar();
        javax.swing.JMenu jm1 = new javax.swing.JMenu("menu1");
        jm1.setMnemonic(java.awt.event.KeyEvent.VK_M);
        jm1.add(new javax.swing.JMenuItem("item1"));
        jm1.add(new javax.swing.JMenuItem("item2"));
        jm1.add(new javax.swing.JMenuItem("item3"));

        javax.swing.JMenu jm2 = new javax.swing.JMenu("menu1");
        jm2.setMnemonic(java.awt.event.KeyEvent.VK_E);
        jm2.add(new javax.swing.JMenuItem("item1"));
        jm2.add(new javax.swing.JMenuItem("item2"));
        jm2.add(new javax.swing.JMenuItem("item3"));

        jmb.add(jm1);
        jmb.add(jm2);
        this.setJMenuBar(jmb);

        // Get a JTextArea to show what happens with the focus
        javax.swing.JTextArea jta = new javax.swing.JTextArea();

        // Disable ALT key presses when the textarea is focused
        jta.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                addAltPostprocessor();
            }

            @Override
            public void focusGained(FocusEvent e) {
                removeAltProcessor();
            }
        });

        this.getContentPane().add(new JScrollPane(jta));
        this.getContentPane().add(new JTextField(), BorderLayout.SOUTH);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // use reflection to remove the Windows L&F ALT processor.
    private void removeAltProcessor() {
        if (altPostprocessor == null) {
            try {
                Method method = KeyboardFocusManager.class.getDeclaredMethod("getKeyEventPostProcessors");
                method.setAccessible(true);
                @SuppressWarnings("unchecked")
                List<KeyEventPostProcessor> list =
                        (List<KeyEventPostProcessor>) method.invoke(KeyboardFocusManager.getCurrentKeyboardFocusManager());
                for (KeyEventPostProcessor pp : list) {
                    if (pp.getClass().getName().contains("WindowsRootPaneUI")) {
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventPostProcessor(pp);
                        altPostprocessor = pp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventPostProcessor(altPostprocessor);
        }
    }

    private void addAltPostprocessor() {
        if (altPostprocessor != null) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventPostProcessor(altPostprocessor);
        }
    }

    public static void main(java.lang.String[] args) {
        new JMenubarAltTest();
    }
}