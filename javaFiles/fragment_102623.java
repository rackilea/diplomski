import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class ScrollImgGlass extends JPanel {
   private static final int BI_W = 40;
   private static final int BI_H = BI_W;
   private static final String[] DATA = { "One", "Two", "Three", "Four",
         "Five", "Six", "Seven", "Eight", "Nine", "Zero", "One", "Two",
         "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Zero",
         "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
         "Nine", "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
         "Eight", "Nine", "Zero" };
   private BufferedImage img = null;
   private JViewport viewport;

   public ScrollImgGlass(JViewport viewport) {
      setOpaque(false);
      this.viewport = viewport;
      img = new BufferedImage(BI_W, BI_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.setColor(Color.red);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.fillOval(0, 0, BI_W, BI_H);
      g2.dispose();
   }

   @Override
   protected void paintComponent(Graphics g) {
      Point vpLocation = viewport.getLocationOnScreen();
      Point gpLocation = getLocationOnScreen();

      int x = vpLocation.x - gpLocation.x;
      int y = vpLocation.y - gpLocation.y;

      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, x, y, this);
      }
   }

   private static void createAndShowGui() {
      JList<String> jList = new JList<String>(DATA);
      jList.setOpaque(false);

      JViewport viewport = new JViewport();
      JScrollPane scrollpane = new JScrollPane();
      scrollpane.setViewport(viewport);
      viewport.setView(jList);

      ScrollImgGlass glass = new ScrollImgGlass(viewport);

      JFrame frame = new JFrame("ScrollImg");
      frame.setGlassPane(glass);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(scrollpane, BorderLayout.CENTER);

      // just to show that this works if the viewport is shifted over
      frame.getContentPane().add(Box.createRigidArea(new Dimension(20, 20)), BorderLayout.NORTH);
      frame.getContentPane().add(Box.createRigidArea(new Dimension(20, 20)), BorderLayout.WEST);

      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      glass.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}