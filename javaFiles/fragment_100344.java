import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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

    public class TestPane extends JPanel {

        private Ball ball;

        public TestPane() {
            ball = new Ball();
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ball.update(getSize());
                    repaint();
                }
            });
            timer.start();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    ball.setHighlighted(ball.wasClicked(e.getPoint()));
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            ball.paint(g2d);
            g2d.dispose();
        }

    }

    public class Ball {

        private int radius = 10;
        private int xDelta, yDelta;
        private Ellipse2D shape = new Ellipse2D.Double(0, 0, radius * 2, radius * 2);
        private boolean highlighted;
        private int cycleCount;

        public Ball() {
            Random rnd = new Random();
            xDelta = rnd.nextInt(3) + 1;
            yDelta = rnd.nextInt(3) + 1;
        }

        public void update(Dimension bounds) {
            Rectangle shapeBounds = shape.getBounds();
            shapeBounds.x += xDelta;
            shapeBounds.y += yDelta;
            if (shapeBounds.x + shapeBounds.width > bounds.width) {
                shapeBounds.x = bounds.width - shapeBounds.width;
                xDelta *= -1;
            } else if (shapeBounds.x < 0) {
                shapeBounds.x = 0;
                xDelta *= -1;
            }
            if (shapeBounds.y + shapeBounds.height > bounds.height) {
                shapeBounds.y = bounds.height - shapeBounds.height;
                yDelta *= -1;
            } else if (shapeBounds.y < 0) {
                shapeBounds.y = 0;
                yDelta *= -1;
            }
            shape.setFrame(shapeBounds);

            if (highlighted) {
                cycleCount++;
                if (cycleCount > 12) {
                    highlighted = false;
                }
            }
        }

        public boolean wasClicked(Point p) {
            return shape.contains(p);
        }

        public void setHighlighted(boolean value) {
            highlighted = value;
            cycleCount = 0;
        }

        public void paint(Graphics2D g) {
            if (highlighted) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }
            g.fill(shape);
        }
    }

}