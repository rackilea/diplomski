import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.*;

public class ImageSwapOnButton {

    public static void main( String[] args ) throws Exception {
        URL url = new URL("http://1point1c.org/gif/thum/plnttm.gif");

        Image image = Toolkit.getDefaultToolkit().createImage(url);
        ImageIcon spinIcon = new ImageIcon(image);
        JOptionPane.showMessageDialog(null, new JLabel(spinIcon));

        // create a static version of this icon
        BufferedImage bi = new BufferedImage(150,150,BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.getGraphics();
        g.drawImage(image,0,0,null);
        g.dispose();
        ImageIcon staticIcon = new ImageIcon(bi);

        JButton button = new JButton(staticIcon);
        button.setRolloverIcon(spinIcon);
        JOptionPane.showMessageDialog(null, button);
    }
}