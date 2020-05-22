import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class MyImageTest extends JPanel {
   // public static final String SPEC = "https://duke.kenai.com/SunRIP/.Midsize/SunRIP.jpg.png";
   public static final String SPEC = "http://upload.wikimedia.org/wikipedia/commons/3/37/"
         + "Mandel_zoom_14_satellite_julia_island.jpg";
   private static final int PREF_H = 786;
   private static final int GAP = 100;
   private BufferedImage img;

   public MyImageTest() {
      try {
         URL imgUrl = new URL(SPEC);
         img = ImageIO.read(imgUrl);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      setLayout(new FlowLayout(FlowLayout.LEADING));
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      JButton b = new JButton();
      b.setPreferredSize(new Dimension(GAP, GAP));
      add(b);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (img == null) {
         return super.getPreferredSize();
      } else {
         int width = (img.getWidth() * PREF_H) / img.getHeight();
         return new Dimension(width, PREF_H);
         // return new Dimension(img.getWidth(), img.getHeight());
      }
   }

   private static void createAndShowGui() {
      try {
         for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      MyImageTest mainPanel = new MyImageTest();

      JFrame frame = new JFrame("MyImageTest");
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