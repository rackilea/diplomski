package some.package;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class PlayWithImages {
   public static final String X_RESOURCE = "x.png";
   private Icon xIcon;

   public PlayWithImages() throws IOException {
      URL xImgUrl = getClass().getResource(X_RESOURCE);
      Image xImg = ImageIO.read(xImgUrl);
      xIcon = new ImageIcon(xImg);
   }

   public Icon getXIcon() {
      return xIcon;
   }

   public static void main(String[] args) {
      try {
         PlayWithImages playWithImages = new PlayWithImages();
         Icon xIcon = playWithImages.getXIcon();
         JOptionPane.showMessageDialog(null, xIcon);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}