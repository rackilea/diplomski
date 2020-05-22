import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class FooFun {

   private static void createAndShowGui() {
      ChildClass mainPanel = new ChildClass();

      JFrame frame = new JFrame("FooFun");
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

abstract class FirstClass extends JPanel {

   private static final int FPS = 20;

   public FirstClass() {
      new Timer(1000 / FPS, taskPerformer).start();
   }

   ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          gameLoop(); //do loop here
          repaint();
      }
  };

  private void gameLoop() {

  }

  @Override
protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2d = (Graphics2D)g;
   paintGame(g2d);
   // Toolkit.getDefaultToolkit().sync();
   // g2d.dispose();
   // g.dispose();
}

  public abstract void paintGame(Graphics2D g2d);
}

class ChildClass extends FirstClass {
   private static final Font font = new Font("Bitmap", Font.PLAIN, 64);
   private static final int PREF_W = 900;
   private static final int PREF_H = 600;
   private static final String NIGHT_IN_VEGAS_TEXT = "a Night in Vegas";
   private static final int NIV_X = 240;
   private static final int NIV_Y = 130;
   private BufferedImage mainImage;

   public ChildClass() {
      mainImage = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = mainImage.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      g2.setFont(font);
      g2.setColor(Color.black);
      g2.drawString(NIGHT_IN_VEGAS_TEXT, NIV_X, NIV_Y); 
      g2.dispose();
   }


   @Override
   public void paintGame(Graphics2D g2d) {
      if (mainImage != null) {
         g2d.drawImage(mainImage, 0, 0, this);     
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

}