import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Lil extends JPanel {

   private static final String URL_PATH = "http://duke.kenai.com/Oracle/" +
        "OracleStratSmall.png";

   BufferedImage image = null;

   public Lil() {
      setBackground(Color.white);
      try {
         image = ImageIO.read(new URL(URL_PATH));
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (image != null) {
         return new Dimension(image.getWidth(), image.getHeight());
      }
      return super.getPreferredSize(); // default
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            Lil lil = new Lil();

            JFrame frame = new JFrame();
            frame.getContentPane().add(lil);
            frame.setTitle("flame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
         }
      });

   }    
}