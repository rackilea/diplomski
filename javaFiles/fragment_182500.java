package whateverpackeyouareusing;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class DefaultFoo {
   public static void main(String[] args) throws IOException {
      String resource = "x.png";
      URL url = Class.class.getResource(resource);
      BufferedImage img = ImageIO.read(url);
      Icon icon = new ImageIcon(img);
      JOptionPane.showMessageDialog(null, icon);
   }
}