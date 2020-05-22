import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CrossImage {

    public static void main(String[] args) {
        new CrossImage();
    }

    public CrossImage() {
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

        private BufferedImage img;
        private ImagePane left;
        private ImagePane right;
        private Point imagePoint;

        public TestPane() {
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridLayout(0, 2, 10, 10));
            left = new ImagePane();
            right = new ImagePane();
            imagePoint = new Point(10, 10);
            left.setImageLocation(imagePoint);
            right.setImageLocation(imagePoint);
            try {
                img = ImageIO.read(new File("Background.jpg"));
                left.setImage(img);
                right.setImage(img);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            add(left);
            add(right);

            MouseAdapter mouseHandler = new MouseAdapter() {
                private Point delta;

                @Override
                public void mousePressed(MouseEvent e) {
                    Point origin = e.getPoint();
                    Rectangle bounds = new Rectangle(imagePoint, new Dimension(img.getWidth(), img.getHeight()));
                    if (bounds.contains(origin)) {
                        delta = new Point(origin.x - imagePoint.x, origin.y - imagePoint.y);
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (delta != null) {
                        imagePoint = e.getPoint();
                        imagePoint.translate(-delta.x, -delta.y);
                        left.setImageLocation(imagePoint);
                        right.setImageLocation(imagePoint);
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    delta = null;
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
        }
    }

    public class ImagePane extends JPanel {

        private Image image;
        private Point imageLocation;

        public ImagePane() {
            setBorder(new LineBorder(Color.DARK_GRAY));
        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? super.getPreferredSize() : new Dimension(image.getWidth(this), image.getHeight(this));
        }

        public void setImage(Image image) {
            this.image = image;
            repaint();
        }

        public void setImageLocation(Point imageLocation) {
            this.imageLocation = imageLocation;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null && imageLocation != null) {
                Point p = SwingUtilities.convertPoint(getParent(), imageLocation, this);
                g.drawImage(image, p.x, p.y, this);
            }
        }
    }
}