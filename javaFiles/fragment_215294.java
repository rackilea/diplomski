import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Overlay {

    public static void main(String[] args) {
        new Overlay();
    }

    public Overlay() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                ImagePane imagePane = new ImagePane();
                imagePane.setLayout(new BorderLayout());
                imagePane.add(new OverlayPane());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(imagePane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class OverlayPane extends JPanel {

        public OverlayPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(4));
            int radius = 40;
            g2d.drawOval(326 - radius / 2, 351 - radius / 2, radius, radius);
            g2d.drawOval(416 - radius / 2, 351 - radius / 2, radius, radius);

            int size = 20;

            g2d.drawLine(374, 400, 374 - size, 400 + size);
            g2d.drawLine(374, 400, 374 + size, 400 + size);

            g2d.dispose();
        }

    }

    public class ImagePane extends JPanel {

        private BufferedImage buffer;

        public ImagePane() {
            try {
                buffer = ImageIO.read(new File("/path/to/your/image"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return buffer == null ? new Dimension(200, 200) : new Dimension(buffer.getWidth(), buffer.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(buffer, 0, 0, this);
            g2d.dispose();
        }
    }

}