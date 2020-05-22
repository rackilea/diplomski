import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.net.URL;

class SizeOfImage {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://i.stack.imgur.com/7bI1Y.jpg");
        final BufferedImage bi = ImageIO.read(url);
        final String size = bi.getWidth() + "x" + bi.getHeight();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JLabel l = new JLabel( 
                    size, 
                    new ImageIcon(bi), 
                    SwingConstants.RIGHT );
                JOptionPane.showMessageDialog(null, l);
            }
        });
    }
}