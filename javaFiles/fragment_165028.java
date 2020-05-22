import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageApp {

    public static void main(String[] args) throws IOException {
        final Image image = ImageIO.read(new File("image.jpg"));
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JPanel component = new JPanel() {

                    @Override
                    public void paintComponent(final Graphics g) {
                        g.drawImage(image, 0, 0, null);
                    }

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(
                            image.getWidth(this), image.getHeight(this));
                    }
                };

                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(component);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}