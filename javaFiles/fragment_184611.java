import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class Foo extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private static final Color BACKGROUND = Color.black;
   private static final Color FILL_COLOR = Color.pink;
   private static final Color DRAW_COLOR = Color.red;
   private static final Stroke STROKE = new BasicStroke(3);
   private List<Rectangle> rectangleList = new ArrayList<>();
   private Point pressPoint = null;
   private Point dragPoint = null;

   public Foo() {
      setBackground(BACKGROUND);
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
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
      Stroke oldStroke = g2.getStroke();
      g2.setStroke(STROKE);
      for (Rectangle rectangle : rectangleList) {
         g2.setColor(FILL_COLOR);
         g2.fill(rectangle);
         g2.setColor(DRAW_COLOR);
         g2.draw(rectangle);
      }
      g2.setStroke(oldStroke);
      if (pressPoint != null && dragPoint != null) {
         g2.setColor(FILL_COLOR.darker());
         int x = Math.min(pressPoint.x, dragPoint.x);
         int y = Math.min(pressPoint.y, dragPoint.y);
         int width = Math.abs(pressPoint.x - dragPoint.x);
         int height = Math.abs(pressPoint.y - dragPoint.y);
         g2.drawRect(x, y, width, height);
      }
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         pressPoint = e.getPoint();
         repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         dragPoint = e.getPoint();
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         dragPoint = e.getPoint();
         int x = Math.min(pressPoint.x, dragPoint.x);
         int y = Math.min(pressPoint.y, dragPoint.y);
         int width = Math.abs(pressPoint.x - dragPoint.x);
         int height = Math.abs(pressPoint.y - dragPoint.y);
         Rectangle rect = new Rectangle(x, y, width, height);
         rectangleList.add(rect);

         pressPoint = null;
         dragPoint = null;
         repaint();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Foo());
      frame.pack();
      frame.setLocationRelativeTo(null);
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