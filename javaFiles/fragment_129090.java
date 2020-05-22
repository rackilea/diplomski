import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FontImage {

    public static void main(String[] args) {
        new FontImage();
    }

    public FontImage() {
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

        public TestPane() {
            try {
                img = ImageIO.read(getClass().getResource("/EwnpgTF.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public List<BufferedImage> convert(String text) {

            List<BufferedImage> images = new ArrayList<>(25);

            for (char c : text.toCharArray()) {
                c = Character.toUpperCase(c);
                int smudge = 1;
                int offset = -1;
                if (c >= 48 && c <= 57) {
                    offset = c - 48;
                } else if (c >= 65 && c <= 90) {
                    offset = c - 65 + 10;
                } else if (c == 32) {
                    offset = 48;
                    smudge = 2;
                }

                if (offset >= 0) {
                    BufferedImage sub = img.getSubimage((offset * 8) + smudge, 0, 8 - smudge, 8);
                    images.add(sub);
                }
            }

            return images;

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            List<BufferedImage> text = convert("This is a test");
            int x = (getWidth() - (8 * text.size())) / 2;
            int y = (getHeight() - 8) / 2;
            for (BufferedImage img : text) {
                g2d.drawImage(img, x, y, this);
                x += img.getWidth();
            }
            g2d.dispose();
        }
    }

}