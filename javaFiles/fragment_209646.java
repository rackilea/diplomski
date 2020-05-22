import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class IntersectionImagePanel extends JPanel {
   private static final String INTERSECTION_LINK = "http://www.weinerlawoffice.com/" +
        "accident-diagram.jpg";
   private BufferedImage intersectionImage;

   public IntersectionImagePanel() {
      URL imageUrl;
      try {
         imageUrl = new URL(INTERSECTION_LINK);
         intersectionImage = ImageIO.read(imageUrl );
      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (intersectionImage != null) {
         g.drawImage(intersectionImage, 0, 0, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (intersectionImage != null) {
         int width = intersectionImage.getWidth();
         int height = intersectionImage.getHeight();
         return new Dimension(width , height );
      }
      return super.getPreferredSize();
   }

   private static void createAndShowGui() {
      IntersectionImagePanel mainPanel = new IntersectionImagePanel();

      JFrame frame = new JFrame("IntersectionImage");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}