import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class U4b extends JPanel {
   private static final Color BG = Color.white;
   private static final Color DRAW_COLOR = Color.red;
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final Stroke BASIC_STROKE = new BasicStroke(3f);
   private int counter = 0;
   private int x1 = 0;
   private int y1 = 0;
   private int x2 = 0;
   private int y2 = 0;

   public U4b() {
      setBackground(BG);
      MyMouseListener myMouseListener = new MyMouseListener();
      addMouseListener(myMouseListener);
      addMouseMotionListener(myMouseListener);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(DRAW_COLOR);
      g2.setStroke(BASIC_STROKE);
      g2.drawLine(x1, y1, x2, y2);
   }

   private class MyMouseListener extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         counter++;
         System.out.println("Counter: " + counter);
         x1 = e.getX();
         y1 = e.getY();
         x2 = x1;
         y2 = y1;
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         x2 = e.getX();
         y2 = e.getY();
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         x2 = e.getX();
         y2 = e.getY();
         repaint();
      }

   }

   private static void createAndShowGui() {
      U4b mainPanel = new U4b();

      JFrame frame = new JFrame("U4b");
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