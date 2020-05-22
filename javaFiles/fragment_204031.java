import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class SimpleFrame2 extends JPanel {
   private static final Color ELLIPSE_COLOR = Color.LIGHT_GRAY;
   private static final Color ELLIPSE_FILL_COLOR = Color.blue;
   private static final int PREF_W = 600;
   private static final int PREF_H = 500;
   public static final int ELLIPSE_WIDTH = 100;
   public static final int ELLIPSE_HEIGHT = 50;
   private static final Stroke ELLIPSE_STROKE = new BasicStroke(2f);
   private List<Shape> shapes = new ArrayList<Shape>();

   public SimpleFrame2() {
      addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent mEvt) {
            double x = mEvt.getX() - ELLIPSE_WIDTH / 2;
            double y = mEvt.getY() - ELLIPSE_HEIGHT / 2;
            double w = ELLIPSE_WIDTH;
            double h = ELLIPSE_HEIGHT;
            shapes.add(new Ellipse2D.Double(x, y, w, h));
            repaint();
         }
      });
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      // to draw smooth edges
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(ELLIPSE_STROKE);
      for (Shape shape : shapes) {
         g2.setColor(ELLIPSE_FILL_COLOR);
         g2.fill(shape);
         g2.setColor(ELLIPSE_COLOR);
         g2.draw(shape);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("SimpleFrame2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SimpleFrame2());
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