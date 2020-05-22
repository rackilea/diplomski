import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class SimExample extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = PREF_W;
   private static final Color BKGD_COLOR = new Color(0, 230, 0);
   private BufferedImage bkgrnd = new BufferedImage(PREF_W, PREF_H,
         BufferedImage.TYPE_INT_ARGB);

   public SimExample() {
      Graphics2D g = bkgrnd.createGraphics();
      g.setBackground(BKGD_COLOR);
      g.clearRect(0, 0, PREF_W, PREF_H);
      g.setColor(Color.black);
      for (int x = 0; x < 50; x++) {
         for (int y = 0; y < 50; y++) {

            g.drawRect((x * 10), (y * 10), 10, 10);
         }
      }
      g.dispose();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      if (bkgrnd != null) {
         g.drawImage(bkgrnd, 0, 0, null);
      }

      // draw sprites here
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      SimExample mainPanel = new SimExample();

      JFrame frame = new JFrame("SimExample");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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