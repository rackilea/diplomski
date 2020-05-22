import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TransparentImageCollision {

    public static void main(String[] args) {
        new TransparentImageCollision();
    }

    public TransparentImageCollision() {
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

        private BufferedImage fly;
        private BufferedImage spider;

        private Rectangle spiderBounds;
        private Rectangle flyBounds;

        private Point spiderDelta;
        private Point flyDelta;

        private Rectangle collision;

        public TestPane() {
            try {
                fly = ImageIO.read(getClass().getResource("/fly.png"));
                spider = ImageIO.read(getClass().getResource("/spider.png"));

                Dimension size = getPreferredSize();
                int width = size.width;
                int height = size.height;

                spiderBounds = new Rectangle();
                spiderBounds.setSize(spider.getWidth(), spider.getHeight());
                spiderBounds.setLocation(0, (height - spider.getHeight()) / 2);

                flyBounds = new Rectangle();
                flyBounds.setSize(fly.getWidth(), fly.getHeight());
                flyBounds.setLocation(width - fly.getWidth(), (height - fly.getHeight()) / 2);

                spiderDelta = new Point(1, 0);
                flyDelta = new Point(-1, 0);

                Timer timer = new Timer(40, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        update(spiderBounds, spiderDelta);
                        update(flyBounds, flyDelta);
                        detectCollision();
                        repaint();
                    }
                });
                timer.start();
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

        protected void update(Rectangle bounds, Point delta) {
            bounds.x += delta.x;
            bounds.y += delta.y;
            if (bounds.x < 0) {
                bounds.x = 0;
                delta.x *= -1;
            }
            if (bounds.x + bounds.width > getWidth()) {
                bounds.x = getWidth() - bounds.width;
                delta.x *= -1;
            }
            if (bounds.y < 0) {
                bounds.y = 0;
                delta.y *= -1;
            }
            if (bounds.y + bounds.height > getHeight()) {
                bounds.y = getHeight() - bounds.height;
                delta.y *= -1;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.drawImage(spider, spiderBounds.x, spiderBounds.y, this);
            g2d.drawImage(fly, flyBounds.x, flyBounds.y, this);

            if (collision != null) {
                g2d.setColor(new Color(255, 0, 0, 128));
                g2d.fill(collision);
            }

            g2d.dispose();
        }

        /**
         * Used to detect the collision between non-alpha portions of the two
         * images
         */
        protected void detectCollision() {
            collision = null;
            // Check if the boundires intersect
            if (spiderBounds.intersects(flyBounds)) {
                // Calculate the collision overlay
                Rectangle bounds = getCollision(spiderBounds, flyBounds);
                if (!bounds.isEmpty()) {
                    // Check all the pixels in the collision overlay to determine
                    // if there are any non-alpha pixel collisions...
                    for (int x = bounds.x; x < bounds.x + bounds.width; x++) {
                        for (int y = bounds.y; y < bounds.y + bounds.height; y++) {
                            if (collision(x, y)) {
                                collision = bounds;
                                break;
                            }
                        }
                    }
                }
            }
        }

        protected Rectangle getCollision(Rectangle rect1, Rectangle rect2) {
            Area a1 = new Area(rect1);
            Area a2 = new Area(rect2);
            a1.intersect(a2);
            return a1.getBounds();
        }

        /**
         * Test if a given x/y position of the images contains transparent
         * pixels or not...
         * @param x
         * @param y
         * @return 
         */
        protected boolean collision(int x, int y) {
            boolean collision = false;

            int spiderPixel = spider.getRGB(x - spiderBounds.x, y - spiderBounds.y);
            int flyPixel = fly.getRGB(x - flyBounds.x, y - flyBounds.y);
            // 255 is completely transparent, you might consider using something
            // a little less absolute, like 225, to give you a sligtly
            // higher hit right, for example...
            if (((spiderPixel >> 24) & 0xFF) < 255 && ((flyPixel >> 24) & 0xFF) < 255) {
                collision = true;
            }
            return collision;
        }
    }
}