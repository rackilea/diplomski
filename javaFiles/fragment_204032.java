import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleFrame3 extends JPanel {
   private static final Color ELLIPSE_COLOR = Color.LIGHT_GRAY;
   private static final Color ELLIPSE_FILL_COLOR = Color.blue;
   private static final int PREF_W = 600;
   private static final int PREF_H = 500;
   public static final int ELLIPSE_WIDTH = 100;
   public static final int ELLIPSE_HEIGHT = 50;
   private static final Stroke ELLIPSE_STROKE = new BasicStroke(2f);
   private List<RectangularShape> rects = new ArrayList<RectangularShape>();

   public SimpleFrame3() {
      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      // to draw smooth edges
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(ELLIPSE_STROKE);
      for (RectangularShape rect : rects) {
         g2.setColor(ELLIPSE_FILL_COLOR);
         g2.fill(rect);
         g2.setColor(ELLIPSE_COLOR);
         g2.draw(rect);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   class MyMouseAdapter extends MouseAdapter {
      private RectangularShape selectedRect = null;
      private Point deltaPt = null;

      @Override
      public void mousePressed(MouseEvent mEvt) {
         if (mEvt.getButton() != MouseEvent.BUTTON1) {
            return;
         }

         if (rects.size() > 0) {
            for (int i = rects.size() - 1; i >= 0; i--) {
               if (rects.get(i).contains(mEvt.getPoint())) {
                  selectedRect = rects.get(i);
                  rects.remove(selectedRect);
                  rects.add(rects.size(), selectedRect);
                  deltaPt = new Point(mEvt.getX() - selectedRect.getBounds().x,
                        mEvt.getY() - selectedRect.getBounds().y);
                  repaint();
                  return;
               }
            }
         }
         double x = mEvt.getX() - ELLIPSE_WIDTH / 2;
         double y = mEvt.getY() - ELLIPSE_HEIGHT / 2;
         double w = ELLIPSE_WIDTH;
         double h = ELLIPSE_HEIGHT;
         Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
         rects.add(ellipse);
         selectedRect = ellipse;
         deltaPt = new Point((int)(mEvt.getX() - x), (int)(mEvt.getY() - y));
         repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (selectedRect != null) {
            Rectangle bounds = selectedRect.getBounds();
            bounds.setLocation(e.getX() - deltaPt.x, e.getY() - deltaPt.y);
            selectedRect.setFrame(bounds.x, bounds.y, bounds.width, bounds.height);
            repaint();
         }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (selectedRect != null) {
            repaint();
            selectedRect = null;
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("SimpleFrame3");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SimpleFrame3());
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