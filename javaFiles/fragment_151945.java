import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestKeyBindings {

    public static void main(String[] args) {
        new TestKeyBindings();
    }

    public TestKeyBindings() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private final List<String> keys;
        private final JLabel lblKeys = new JLabel("<nothing>");

        public TestPane() {
            keys = new ArrayList<>(3);
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W-Down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "D-Down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_G, 0, false), "G-Down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "A-Down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "W-Up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "D-Up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_G, 0, true), "G-Up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "A-Up");

            ActionMap am = getActionMap();
            am.put("W-Down", new KeyDownAction("W"));
            am.put("D-Down", new KeyDownAction("D"));
            am.put("G-Down", new KeyDownAction("G"));
            am.put("A-Down", new KeyDownAction("A"));
            am.put("W-Up", new KeyUpAction("W"));
            am.put("D-Up", new KeyUpAction("D"));
            am.put("G-Up", new KeyUpAction("G"));
            am.put("A-Up", new KeyUpAction("A"));

            setLayout(new GridBagLayout());
            add(lblKeys);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void update() {
            StringBuilder sb = new StringBuilder(128);
            if (keys.isEmpty()) {
                sb.append("<nothing>");
            } else {
                for (String key : keys) {
                    if (sb.length() > 0) {
                        sb.append("+");
                    }
                    sb.append(key);
                }
            }
            lblKeys.setText(sb.toString());
        }

        public void addKey(String key) {
            if (!keys.contains(key)) {
                keys.add(key);
                update();
            }
        }

        public void removeKey(String key) {
            keys.remove(key);
            update();
        }

        public class KeyDownAction extends AbstractAction {

            private final String key;

            public KeyDownAction(String key) {
                this.key = key;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                addKey(key);
            }

        }

        public class KeyUpAction extends AbstractAction {

            private final String key;

            public KeyUpAction(String key) {
                this.key = key;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                removeKey(key);
            }

        }

    }

}