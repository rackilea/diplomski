import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TransparentPane {

    public static void main(String[] args) {
        new TransparentPane();
    }

    public TransparentPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                BackgroundPane backgroundPane = new BackgroundPane();
                backgroundPane.setBackground(Color.RED);
                backgroundPane.setLayout(new BorderLayout());
                backgroundPane.add(new TranslucentPane());

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(backgroundPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BackgroundPane extends JPanel {

        private BufferedImage bg;

        public BackgroundPane() {
            try {
                bg = ImageIO.read(new File("/path/to/your/image.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return bg == null ? super.getPreferredSize() : new Dimension(bg.getWidth(), bg.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                int width = getWidth() - 1;
                int height = getHeight() - 1;
                int x = (width - bg.getWidth()) / 2;
                int y = (height - bg.getHeight()) / 2;
                g.drawImage(bg, x, y, this);
            }
        }

    }

    public class TranslucentPane extends JPanel {

        public TranslucentPane() {
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Rectangle fill = new Rectangle(getWidth(), getHeight());
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth() - 1;
            int height = getHeight() - 1;
            int radius = Math.min(width, height) / 2;
            int x = (width - radius) / 2;
            int y = (height - radius) / 2;

            Ellipse2D hole = new Ellipse2D.Float(x, y, radius, radius);

            Area area = new Area(fill);
            area.subtract(new Area(hole));
            g2d.setColor(getBackground());
            g2d.fill(area);

            g2d.setColor(Color.RED);
            g2d.setComposite(AlphaComposite.SrcOver.derive(0.25f));
            g2d.fill(hole);

            g2d.dispose();
        }

    }

}