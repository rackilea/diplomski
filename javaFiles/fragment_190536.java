import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

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
                frame.setContentPane(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Surface surface;

        public TestPane() {
            setLayout(new BorderLayout());

            surface = new Surface();

            InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "Pressed.left");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "Release.left");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "Pressed.right");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "Release.right");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "Pressed.up");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "Release.up");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "Pressed.down");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "Release.down");

            actionMap.put("Pressed.left", surface.getLeftPressAction());
            actionMap.put("Release.left", surface.getLeftReleaseAction());
            actionMap.put("Pressed.right", surface.getRightPressAction());
            actionMap.put("Release.right", surface.getRightReleaseAction());
            actionMap.put("Pressed.up", surface.getUpPressAction());
            actionMap.put("Release.up", surface.getUpReleaseAction());
            actionMap.put("Pressed.down", surface.getDownPressAction());
            actionMap.put("Release.down", surface.getDownReleaseAction());

            add(surface);
        }

    }

    public class Surface extends Canvas {

        private String displayText = "...";

        @Override
        public void paint(Graphics g) {
            super.paint(g); 
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(displayText)) / 2;
            int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g2d.drawString(displayText, x, y);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public Action getLeftPressAction() {
            return new TextAction("Left");
        }

        public Action getLeftReleaseAction() {
            return new ClearAction();
        }

        public Action getRightPressAction() {
            return new TextAction("Right");
        }

        public Action getRightReleaseAction() {
            return new ClearAction();
        }

        public Action getUpPressAction() {
            return new TextAction("Up");
        }

        public Action getUpReleaseAction() {
            return new ClearAction();
        }

        public Action getDownPressAction() {
            return new TextAction("Down");
        }

        public Action getDownReleaseAction() {
            return new ClearAction();
        }

        public class TextAction extends AbstractAction {
            private String text;

            public TextAction(String text) {
                this.text = text;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                displayText = text;
                repaint();
            }

        }

        public class ClearAction extends AbstractAction {

            @Override
            public void actionPerformed(ActionEvent e) {
                displayText = "...";
                repaint();
            }

        }

    }

}