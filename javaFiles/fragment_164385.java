import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TestUrls {
   public static final String BASE_URL_PATH = "http://static.ed.edmunds-media.com/" +
        "unversioned/adunit/homepage_showcase/";
   public static final String[] URL_PATHS = {
      "honda-odyssey-2013.png",
      "chevrolet-impala-2013.png",
      "mazda-cx9-2013.png",
      "toyota-rav4-2013-2.png"
   };

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            for (String urlPath : URL_PATHS) {
               String fullUrlPath = BASE_URL_PATH + urlPath;
               try {
                  URL url = new URL(fullUrlPath);
                  BufferedImage img = ImageIO.read(url);
                  ImageIcon icon = new ImageIcon(img);
                  JOptionPane.showMessageDialog(null, icon);
               } catch (MalformedURLException e) {
                  e.printStackTrace();
               } catch (IOException e) {
                  e.printStackTrace();
               } 
            }
         }
      });
   }
}