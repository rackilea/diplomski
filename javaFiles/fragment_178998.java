import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.beans.Transient;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageTest extends JPanel {

    private BufferedImage image;
    private BufferedImage saved;

    public ImageTest(int w, int h) {
        image = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        randomizeImage(image);
        saveAndLoadImage();
        saveResultToLossLess();
    }

    private void saveResultToLossLess() {
        BufferedImage result = new BufferedImage(image.getWidth() * 2,
                image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        result.getGraphics().drawImage(image, 0, 0, null);
        result.getGraphics().drawImage(saved, image.getWidth(), 0, null);
        try {
            ImageIO.write(result, "png", new File("comparison.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void randomizeImage(BufferedImage image) {
        // Draw a blue gradient, note that in the array below
        // pixels[i] = blue, pixels[i+1] = green, pixels[i+2] = red
        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer())
                .getData();
        for (int i = 0; i < pixels.length; i += 3) {
            pixels[i] = (byte) (255.0 * i / pixels.length);
            pixels[i + 1] = (byte) (128.0 * i / pixels.length);
            pixels[i + 2] = (byte) (64.0 * i / pixels.length);
        }
    }

    private void saveAndLoadImage() {
        try {
            ImageIO.write(image, "jpg", new File("image.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            saved = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        if (saved != null)
            g.drawImage(saved, image.getWidth(), 0, null);
    }

    @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth() * 2, image.getHeight());
    }

    public static void main(String[] args) {
        ImageTest test = new ImageTest(600, 600);
        JFrame frame = new JFrame();
        frame.getContentPane().add(test);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}