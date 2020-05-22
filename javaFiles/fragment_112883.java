import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test{

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

    public static class TestPane extends JPanel {

        public enum HorizontalMovement {
            NONE,
            LEFT,
            RIGHT
        }

        private HorizontalMovement horizontalMovement = HorizontalMovement.NONE;

        private int xPos = 0;

        public TestPane() {
            addKeyPressedBinding("left.pressed", KeyEvent.VK_LEFT, new MoveHorizontialAction(HorizontalMovement.LEFT));
            addKeyPressedBinding("right.pressed", KeyEvent.VK_RIGHT, new MoveHorizontialAction(HorizontalMovement.RIGHT));
            addKeyReleasedBinding("left.relesed", KeyEvent.VK_LEFT, new MoveHorizontialAction(HorizontalMovement.NONE));
            addKeyReleasedBinding("right.relesed", KeyEvent.VK_RIGHT, new MoveHorizontialAction(HorizontalMovement.NONE));

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (horizontalMovement) {
                        case LEFT:
                            xPos--;
                            break;
                        case RIGHT:
                            xPos++;
                            break;
                    }
                    if (xPos < 0) {
                        xPos = 0;
                    } else if (xPos + 50 > getWidth()) {
                        xPos = getWidth() - 50;
                    }
                    repaint();
                }
            });
            timer.start();

        }

        protected void addKeyPressedBinding(String name, int keyCode, Action action) {
            KeyStroke ks = KeyStroke.getKeyStroke(keyCode, 0, false);
            addKeyBinding(name, ks, action);
        }

        protected void addKeyReleasedBinding(String name, int keyCode, Action action) {
            KeyStroke ks = KeyStroke.getKeyStroke(keyCode, 0, true);
            addKeyBinding(name, ks, action);
        }

        protected void addKeyBinding(String name, KeyStroke ks, Action action) {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(ks, name);
            am.put(name, action);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Rectangle box = new Rectangle(xPos, (getHeight() - 50) / 2, 50, 50);
            g2d.setColor(Color.BLUE);
            g2d.fill(box);
            g2d.dispose();
        }

        protected void addKeyBinding(String left, int VK_LEFT, MoveHorizontialAction moveHorizontialAction) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        protected class MoveHorizontialAction extends AbstractAction {

            private HorizontalMovement movement;

            public MoveHorizontialAction(HorizontalMovement movement) {
                this.movement = movement;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                horizontalMovement = movement;
            }

        }

    }

}