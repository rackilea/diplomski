import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CheckPointCharlie {

    public static void main(String[] args) {
        new CheckPointCharlie();
    }

    public CheckPointCharlie() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new CheckPointsPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CheckPointsPane extends JPanel {

        private List<Rectangle> checkpoints;
        private Rectangle player;

        public CheckPointsPane() {
            checkpoints = new ArrayList<>(20);
            int count = (int)(Math.random() * 20);
            while (checkpoints.size() < count) {
                int x = (int)(Math.random() * 195);
                int y = (int)(Math.random() * 195);
                Rectangle rect = new Rectangle(x, y, 5, 5);
                boolean keep = true;
                for (Rectangle check : checkpoints) {
                    if (check.intersects(rect)) {
                        keep = false;
                        break;
                    }
                }
                if (keep) {
                    checkpoints.add(rect);
                }
            }
            player = new Rectangle(95, 95, 10, 10);
            checkCollisions();

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Right");

            ActionMap am = getActionMap();
            am.put("Up", new MovementAction(this, player, 0, -4));
            am.put("Down", new MovementAction(this, player, 0, 4));
            am.put("Left", new MovementAction(this, player, -4, 0));
            am.put("Right", new MovementAction(this, player, 4, 0));
        }

        protected void checkCollisions() {
            Iterator<Rectangle> it = checkpoints.iterator();
            while (it.hasNext()) {
                Rectangle check = it.next();
                if (player.intersects(check)) {
                    it.remove();
                }
            }
            repaint();
            if (checkpoints.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You rock!");
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            for (Rectangle rect : checkpoints) {
                g2d.fill(rect);
            }
            g2d.setColor(Color.BLUE);
            g2d.fill(player);
            g2d.dispose();
        }
    }

    public class MovementAction extends AbstractAction {

        private CheckPointsPane parent;
        private Rectangle player;
        private int xDelta;
        private int yDelta;

        private MovementAction(CheckPointsPane parent, Rectangle player, int xDelta, int yDelta) {
            this.parent = parent;
            this.player = player;
            this.xDelta = xDelta;
            this.yDelta = yDelta;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            player.x += xDelta;
            player.y += yDelta;
            if (player.x < 0) {
                player.x = 0;
            } else if (player.x + player.width > parent.getWidth()) {
                player.x = parent.getWidth() - player.width;
            }
            if (player.y < 0) {
                player.y = 0;
            } else if (player.y + player.height > parent.getHeight()) {
                player.y = parent.getHeight() - player.height;
            }
            parent.checkCollisions();
        }

    }

}