import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestImageRotate {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                JFrame frame = new JFrame("Image Timer");
                frame.add(new ImagePanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static class ImagePanel extends JPanel {

        URL[] urls;
        BufferedImage[] images;
        Random rand = new Random();

        public ImagePanel() {
            urls = new URL[5];
            try {
                urls[0] = new URL("http://www.atomicframework.com/assetsY/img/stackoverflow_chicklet.png");
                urls[1] = new URL("http://www.iconsdb.com/icons/download/orange/stackoverflow-256.png");
                urls[2] = new URL("http://img.1mobile.com/market/screenshot/50/com.dd.stackoverflow/0.png");
                urls[3] = new URL("http://www.iconsdb.com/icons/download/orange/stackoverflow-4-512.png");
                urls[4] = new URL("http://www.iconsdb.com/icons/preview/light-gray/stackoverflow-xxl.png");

                images = new BufferedImage[5];
                images[0] = ImageIO.read(urls[0]);
                images[1] = ImageIO.read(urls[1]);
                images[2] = ImageIO.read(urls[2]);
                images[3] = ImageIO.read(urls[3]);
                images[4] = ImageIO.read(urls[4]);

            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setBackground(Color.BLACK);

            Timer timer = new Timer(500, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
        }

        private int random() {
            int index = rand.nextInt(5);
            return index;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage img = images[random()];
            g.drawImage(img, 0, 0, 400, 400, 0, 0,
                    img.getWidth(), img.getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
}