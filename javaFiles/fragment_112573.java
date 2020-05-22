import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowImage {

   // ******* add the path to the image resource below *****
   private static final String IMAGE_RESOURCE_PATH = "";

   public static void main(String[] args) {
      URL imgUrl = ShowImage.class.getResource(IMAGE_RESOURCE_PATH);
      BufferedImage img;
      try {
         img = ImageIO.read(imgUrl);
         if (img == null) {

            String message = "Image cannot be found at \""
                  + IMAGE_RESOURCE_PATH + "\"";
            JOptionPane.showMessageDialog(null, message);
            System.exit(-1);

         }
         Icon icon = new ImageIcon(img);
         JOptionPane.showMessageDialog(null, icon);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}