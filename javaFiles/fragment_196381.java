import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Imager {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ImagePanel("image.jpg"));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static class ImagePanel extends JPanel {

        BufferedImage img;

        ImagePanel(String name) {
            this.setToolTipText(name);
            this.add(new JLabel(name));
            try {
                img = ImageIO.read(new File(name));
                this.setPreferredSize(new Dimension(
                    img.getWidth(), img.getHeight()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            // super.paintComponent(g);
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
}