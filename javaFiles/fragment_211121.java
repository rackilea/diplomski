import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ClickImage {

    public static void main(String[] args) {
        new ClickImage();
    }

    public ClickImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ImagePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImagePane extends JPanel {

        private BufferedImage background;
        private List<Point> goodPoints;
        private List<Point> badPoints;

        public ImagePane() {
            try {
                background = ImageIO.read(new File("/Volumes/Disk02/Dropbox/MegaTokyo/url.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            goodPoints = new ArrayList<>(5);
            badPoints = new ArrayList<>(5);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (getImageBounds().contains(e.getPoint())) {
                        goodPoints.add(e.getPoint());
                    } else {
                        badPoints.add(e.getPoint());
                    }
                    repaint();
                }
            });
        }

        @Override
        public void invalidate() {
            goodPoints.clear();
            badPoints.clear();
            super.invalidate();
        }

        public Rectangle getImageBounds() {
            Rectangle bounds = new Rectangle();
            if (background != null) {
                bounds.x = (getWidth() - background.getWidth()) / 2;
                bounds.y = (getHeight() - background.getHeight()) / 2;
                bounds.width = background.getWidth();
                bounds.height = background.getHeight();
            }

            return bounds;            
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? super.getPreferredSize() : getImageBounds().getSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                Rectangle bounds = getImageBounds();
                g2d.drawImage(background, bounds.x, bounds.y, this);

                g2d.setColor(Color.GREEN);
                drawPoints(g2d, goodPoints);
                g2d.setColor(Color.RED);
                drawPoints(g2d, badPoints);

                g2d.dispose();
            }
        }

        protected void drawPoints(Graphics2D g2d, List<Point> points) {
            for (Point p : points) {
                g2d.drawLine(p.x - 4, p.y - 4, p.x + 4, p.y + 4);
                g2d.drawLine(p.x + 4, p.y - 4, p.x - 4, p.y + 4);
            }
        }
    }
}