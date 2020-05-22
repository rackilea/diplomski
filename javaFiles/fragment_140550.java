import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.net.URL;

class ImageTransparencyByColor {

    public static BufferedImage getTransparentImage(
        BufferedImage image, Color transparent) {
        // must have a transparent image
        BufferedImage img = new BufferedImage(
            image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g= img.createGraphics();
        for (int x=0; x<img.getWidth(); x++) {
            for (int y=0; y<img.getHeight(); y++) {
                if (image.getRGB(x,y)!=transparent.getRGB()) {
                    img.setRGB( x,y, image.getRGB(x,y) );
                }
            }
        }
        g.dispose();
        return img;
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL ("http://www.gravatar.com/avatar" +
            "/ab5193916ccf152f96b0a69323e934a1?s=128&d=identicon&r=PG");
        final BufferedImage trans = getTransparentImage(
            ImageIO.read(url), Color.WHITE);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JLabel gui = new JLabel(new ImageIcon(trans));
                JOptionPane.showMessageDialog(null, gui);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}