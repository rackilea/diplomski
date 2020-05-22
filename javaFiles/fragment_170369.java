import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class TestButtonOverImage {

    public TestButtonOverImage() {
        JFrame frame = new JFrame("Test Card");
        frame.add(new ImagePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestButtonOverImage();
            }
        });
    }

    public class ImagePanel extends JPanel {

        BufferedImage img;

        public ImagePanel() {
            setLayout(new GridBagLayout());
            add(new JButton("StackOverflow Button"));

            try {
                img = ImageIO.read(new URL("http://d8u1nmttd4enu.cloudfront.net/designs/logo-stackoverflow-logo-design-99designs_447080~36d200d82d83d7b2e738cebd2a48de07180cef3a_largecrop"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(TestButtonOverImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestButtonOverImage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 100, 100, 300, 300, this);
        }

        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }
    }
}