import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class KeyBindingsTest {

    public static void main(String[] args) {
        new KeyBindingsTest();
    }

    public KeyBindingsTest() {
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

    public interface InputManager {

        public void upWasPerformed(boolean active);
        public void downWasPerformed(boolean active);
        public void leftWasPerformed(boolean active);
        public void rightWasPerformed(boolean active);

    }

    public static class TestPane extends JPanel implements InputManager {

        public static final LineBorder LINE_BORDER = new LineBorder(Color.RED);
        public static final EmptyBorder EMPTY_BORDER = new EmptyBorder(1, 1, 1, 1);

        private JLabel up;
        private JLabel down;
        private JLabel left;
        private JLabel right;

        public TestPane() {
            setLayout(new GridBagLayout());
            up = new JLabel("UP");
            up.setBorder(EMPTY_BORDER);

            down = new JLabel("DOWN");
            down.setBorder(EMPTY_BORDER);

            left = new JLabel("LEFT");
            left.setBorder(EMPTY_BORDER);

            right = new JLabel("RIGHT");
            right.setBorder(EMPTY_BORDER);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(left, gbc);
            gbc.gridx++;
            gbc.gridy = 0;
            add(up, gbc);
            gbc.gridy = 2;
            add(down, gbc);
            gbc.gridx++;
            gbc.gridy = 1;
            add(right, gbc);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up.pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up.released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down.pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down.released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left.pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left.released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right.pressed");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right.released");

            ActionMap am = getActionMap();
            am.put("up.pressed", new UpAction(this, true));
            am.put("up.released", new UpAction(this, false));
            am.put("down.pressed", new DownAction(this, true));
            am.put("down.released", new DownAction(this, false));
            am.put("left.pressed", new LeftAction(this, true));
            am.put("left.released", new LeftAction(this, false));
            am.put("right.pressed", new RightAction(this, true));
            am.put("right.released", new RightAction(this, false));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void upWasPerformed(boolean active) {
            up.setBorder(active ? LINE_BORDER : EMPTY_BORDER);
        }

        @Override
        public void downWasPerformed(boolean active) {
            down.setBorder(active ? LINE_BORDER : EMPTY_BORDER);
        }

        @Override
        public void leftWasPerformed(boolean active) {
            left.setBorder(active ? LINE_BORDER : EMPTY_BORDER);
        }

        @Override
        public void rightWasPerformed(boolean active) {
            right.setBorder(active ? LINE_BORDER : EMPTY_BORDER);
        }

    }

    public static abstract class InputManagerAction extends AbstractAction {

        private InputManager manager;
        private boolean activate;

        public InputManagerAction(InputManager manager, boolean activate) {
            this.manager = manager;
            this.activate = activate;
        }

        public InputManager getManager() {
            return manager;
        }

        public boolean shouldActivate() {
            return activate;
        }

    }

    public static class UpAction extends InputManagerAction {

        public UpAction(InputManager manager, boolean activate) {
            super(manager, activate);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getManager().upWasPerformed(shouldActivate());
        }

    }

    public static class DownAction extends InputManagerAction {

        public DownAction(InputManager manager, boolean activate) {
            super(manager, activate);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getManager().downWasPerformed(shouldActivate());
        }

    }

    public static class LeftAction extends InputManagerAction {

        public LeftAction(InputManager manager, boolean activate) {
            super(manager, activate);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getManager().leftWasPerformed(shouldActivate());
        }

    }

    public static class RightAction extends InputManagerAction {

        public RightAction(InputManager manager, boolean activate) {
            super(manager, activate);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getManager().rightWasPerformed(shouldActivate());
        }

    }
}