import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class DragShapesMainPanel extends JPanel {
   private static final Dimension RIGHT_PANEL_SIZE = new Dimension(300, 450);
   private static final int SHAPE_COUNT = 10;
   private static final int SHAPE_WIDTH = 40;
   private static final int SHAPE_HEIGHT = SHAPE_WIDTH;
   private Shape draggedShape = null;
   private DragShapesPanel leftPanel = new DragShapesPanel(Color.blue, Color.black);
   private DragShapesPanel rightPanel = new DragShapesPanel(Color.blue, Color.black);
   private DragShapesGlassPanel glassPanel = new DragShapesGlassPanel(Color.pink, Color.gray);
   private Random random = new Random();

   public DragShapesMainPanel() {
      setLayout(new GridLayout(1, 0));
      setBackground(Color.black);
      rightPanel.setPreferredSize(RIGHT_PANEL_SIZE);
      leftPanel.setPreferredSize(RIGHT_PANEL_SIZE);
      rightPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      leftPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      add(leftPanel);
      add(rightPanel);

      MouseAdapter myMouseAdapter = new MyMouseAdapter();
      glassPanel.addMouseListener(myMouseAdapter);
      glassPanel.addMouseMotionListener(myMouseAdapter);

      glassPanel.setOpaque(false);
      glassPanel.setVisible(true);

      for (int i = 0; i < SHAPE_COUNT; i++) {
         leftPanel.addShape(createRandomShape(i));
      }
   }

   private Shape createRandomShape(int i) {
      Dimension size = rightPanel.getPreferredSize();
      int x = random.nextInt(size.width - SHAPE_WIDTH);
      int y = random.nextInt(size.height - SHAPE_HEIGHT);
      switch (i % 3) {
      case 0:
         return new Ellipse2D.Double(x, y, SHAPE_WIDTH, SHAPE_HEIGHT);

      case 1:
         return new Rectangle2D.Double(x, y, SHAPE_WIDTH, SHAPE_HEIGHT);

      case 2:
         return new RoundRectangle2D.Double(x, y, SHAPE_WIDTH, SHAPE_HEIGHT, 15, 15);

      default:
         break;
      }
      return null;
   }

   public JPanel getGlassPanel() {
      return glassPanel;
   }

   private class MyMouseAdapter extends MouseAdapter {
      Point initialLocation = null;

      @Override
      public void mousePressed(MouseEvent e) {
         if (e.getButton() != MouseEvent.BUTTON1) {
            return;
         }
         Component componentAt = getComponentAt(e.getPoint());
         if (!(componentAt instanceof DragShapesPanel)) {
            return;
         }

         initialLocation = e.getPoint();
         DragShapesPanel dsPanel = (DragShapesPanel) getComponentAt(initialLocation);

         int x = initialLocation.x - dsPanel.getLocation().x;
         int y = initialLocation.y - dsPanel.getLocation().y;
         Point p = new Point(x, y);

         Shape shape = dsPanel.getShapeAtPoint(p);
         if (shape == null) {
            initialLocation = null;
            return;
         }

         dsPanel.removeShape(shape);
         dsPanel.repaint();

         int tx = dsPanel.getLocation().x;
         int ty = dsPanel.getLocation().y;
         draggedShape = AffineTransform.getTranslateInstance(tx, ty).createTransformedShape(shape);

         glassPanel.setShape(draggedShape);
         glassPanel.repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (initialLocation == null) {
            return;
         }

         Point currentLocation = e.getPoint();
         int x = currentLocation.x - initialLocation.x;
         int y = currentLocation.y - initialLocation.y;

         glassPanel.translate(new Point(x, y));
         glassPanel.repaint();
      }

      @Override
      public void mouseReleased(final MouseEvent e) {
         if (initialLocation == null) {
            return;
         }
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               Component componentAt = getComponentAt(e.getPoint());
               if (!(componentAt instanceof DragShapesPanel)) {
                  return;
               }

               DragShapesPanel dsPanel = (DragShapesPanel) getComponentAt(e.getPoint());

               Point currentLocation = e.getPoint();
               int x = currentLocation.x - initialLocation.x;
               int y = currentLocation.y - initialLocation.y;

               Point dspPoint = dsPanel.getLocation();
               int tx = x - dspPoint.x;
               int ty = y - dspPoint.y;
               draggedShape = AffineTransform.getTranslateInstance(tx, ty).createTransformedShape(
                        draggedShape);

               dsPanel.addShape(draggedShape);
               dsPanel.repaint();

               initialLocation = null;
               glassPanel.setShape(null);
               glassPanel.translate(new Point(0, 0));
            }
         });
      }
   }

   private static void createAndShowUI() {
      DragShapesMainPanel dragShapesMain = new DragShapesMainPanel();
      JFrame frame = new JFrame("DragShapes");
      frame.getContentPane().add(dragShapesMain);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setGlassPane(dragShapesMain.getGlassPanel());
      frame.getGlassPane().setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

@SuppressWarnings("serial")
class DragShapesPanel extends JPanel {
   private static final float STROKE_WIDTH = 3;
   private static final Stroke SHAPE_STROKE = new BasicStroke(STROKE_WIDTH);
   private List<Shape> shapeList = new ArrayList<Shape>();
   private Color shapeFillColor;
   private Color shapeBorderColor;

   public DragShapesPanel(Color fillColor, Color borderColor) {
      this.shapeFillColor = fillColor;
      this.shapeBorderColor = borderColor;
   }

   public void addShape(Shape s) {
      shapeList.add(s);
   }

   public void removeShape(Shape s) {
      shapeList.remove(s);
   }

   public Shape getShapeAtPoint(Point p) {
      Shape shapeAtPoint = null;
      for (int i = shapeList.size() - 1; i >= 0; i--) {
         if (shapeList.get(i).contains(p)) {
            return shapeList.get(i);
         }
      }
      return shapeAtPoint;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      for (Shape shape : shapeList) {
         g2.setColor(shapeFillColor);
         g2.fill(shape);
         g2.setStroke(SHAPE_STROKE);
         g2.setColor(shapeBorderColor);
         g2.draw(shape);
      }
   }
}

@SuppressWarnings("serial")
class DragShapesGlassPanel extends JPanel {
   private static final float STROKE_WIDTH = 1.5f;
   private static final Stroke SHAPE_STROKE = new BasicStroke(STROKE_WIDTH);
   private Shape shape = null;
   private Color shapeFillColor;
   private Color shapeBorderColor;
   private AffineTransform transform = new AffineTransform();

   public DragShapesGlassPanel(Color fillColor, Color borderColor) {
      this.shapeFillColor = fillColor;
      this.shapeBorderColor = borderColor;
   }

   public void setShape(Shape shape) {
      this.shape = shape;
   }

   public void translate(Point p) {
      transform = AffineTransform.getTranslateInstance(p.x, p.y);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (shape == null) {
         return;
      }
      Graphics2D g2 = (Graphics2D) g;
      g2.transform(transform);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(shapeFillColor);
      g2.fill(shape);
      g2.setStroke(SHAPE_STROKE);
      g2.setColor(shapeBorderColor);
      g2.draw(shape);
   }
}