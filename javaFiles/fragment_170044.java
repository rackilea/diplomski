import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface Movable {

        public void changeLocation(int xDelta, int yDelta);
    }

    public class TestPane extends JPanel implements Movable {

        private Rectangle player;

        public TestPane() {
            String text = "X";
            FontMetrics fm = getFontMetrics(getFont());
            int width = fm.stringWidth(text);
            int height = fm.getHeight();

            player = new Rectangle(0, 0, width, height);

            setupKeyBindings();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void setupKeyBindings() {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");

            int xDelta = player.width;
            int yDelta = player.height;

            am.put("up", new MoveAction(this, 0, -yDelta));
            am.put("down", new MoveAction(this, 0, yDelta));
            am.put("left", new MoveAction(this, -xDelta, 0));
            am.put("right", new MoveAction(this, xDelta, 0));
        }

        @Override
        public void changeLocation(int xDelta, int yDelta) {
            int xPos = player.x + xDelta;
            int yPos = player.y + yDelta;
            if (xPos + player.width > getWidth()) {
                xPos = getWidth() - player.width;
            } else if (xPos < 0) {
                xPos = 0;
            }
            if (yPos + player.height > getHeight()) {
                yPos = getHeight() - player.height;
            } else if (xPos < 0) {
                yPos = 0;
            }
            player.setLocation(xPos, yPos);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.draw(player);
            FontMetrics fm = g2d.getFontMetrics();
            g2d.drawString("X", player.x, player.y + fm.getAscent());
            g2d.dispose();
        }

    }

    public class MoveAction extends AbstractAction {

        private Movable movable;
        private int xDelta;
        private int yDelta;

        public MoveAction(Movable movable, int xDelta, int yDelta) {
            this.movable = movable;
            this.xDelta = xDelta;
            this.yDelta = yDelta;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            movable.changeLocation(xDelta, yDelta);
        }

    }

}