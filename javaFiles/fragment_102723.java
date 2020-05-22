import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Drag {

    public static void main(String[] args) {
        new Drag();
    }

    public Drag() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Point> points;
        private Point pos;

        private int diametere = 10;

        public TestPane() {
            points = new ArrayList<>(25);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");

            ActionMap am = getActionMap();
            am.put("left", new MoveAction(-5, 0));
            am.put("right", new MoveAction(5, 0));
            am.put("up", new MoveAction(0, -5));
            am.put("down", new MoveAction(0, 5));

            pos = new Point(100 - (diametere / 2), 100 - (diametere / 2));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (points.size() > 1) {
                g2d.setColor(Color.RED);
                GeneralPath path = new GeneralPath();
                boolean started = false;
                System.out.println("----");
                for (Point p : points) {
                    if (started) {
                        System.out.println(p);
                        path.lineTo(p.x, p.y);
                    } else {
                        path.moveTo(p.x, p.y);
                        started = true;
                    }
                }
                g2d.draw(path);
            }
            int radius = (int) (diametere / 2d);
            g2d.setColor(Color.GREEN);
            g2d.draw(new Ellipse2D.Double(pos.x - radius, pos.y - radius, diametere, diametere));
            g2d.dispose();
        }

        protected void moveBy(int xDelta, int yDelta) {

            if (pos.x + xDelta < 0) {

                xDelta = 0;
                pos.x = 0;

            } else if (pos.x + xDelta + diametere > getWidth()) {

                xDelta = 0;
                pos.x = getWidth() - diametere;

            }
            if (pos.y + yDelta < 0) {

                yDelta = 0;
                pos.y = 0;

            } else if (pos.y + yDelta + diametere > getHeight()) {

                yDelta = 0;
                pos.y = getWidth() - diametere;

            }

            points.add(new Point(pos));

            pos.x += xDelta;
            pos.y += yDelta;

            repaint();

        }

        public class MoveAction extends AbstractAction {

            private int xDelta;
            private int yDelta;

            public MoveAction(int xDelta, int yDelta) {
                this.xDelta = xDelta;
                this.yDelta = yDelta;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                moveBy(xDelta, yDelta);
            }

        }
    }

}