import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.plaf.LayerUI;

@SuppressWarnings("serial")
public class GraphPane2 extends JPanel {
   private static final int GRAPH_WIDTH = 1000;
   private static final int GRAPH_HEIGHT = 750;
   private Graph2 graph2 = new Graph2(GRAPH_WIDTH, GRAPH_HEIGHT);

   public GraphPane2() {
      LayerUI<Graph2> myLayerUI = new MyLayerUI<Graph2>();
      JLayer<Graph2> panelLayer = new JLayer<Graph2>(graph2, myLayerUI);
      setLayout(new BorderLayout());
      add(panelLayer);

      myLayerUI.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (MyLayerUI.MOUSE_RELEASED.equals(evt.getPropertyName())) {
               Rectangle rect = (Rectangle) evt.getNewValue();
               System.out.println(rect);
            }
         }
      });
   }

   private static void createAndShowGui() {
      GraphPane2 mainPanel = new GraphPane2();

      JFrame frame = new JFrame("Graph Pane2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setResizable(false);
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

@SuppressWarnings("serial")
class MyLayerUI<V extends JComponent> extends LayerUI<V> {
   private static final Color FILL_COLOR = new Color(0, 128, 0, 128);
   public static final String MOUSE_RELEASED = "mouse released";
   private Point pressedPt;
   private Point draggedPt;
   private Rectangle rect;

   @Override
   public void paint(Graphics g, JComponent c) {
      super.paint(g, c);
      if (rect != null) {
         Graphics2D g2 = (Graphics2D) g;
         g2.setColor(FILL_COLOR);
         g2.fill(rect);
      }
   }

   public void installUI(JComponent c) {
      super.installUI(c);
      ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_MOTION_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
   }

   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
      ((JLayer)c).setLayerEventMask(0);
   }

   @Override
   public void eventDispatched(AWTEvent e, JLayer<? extends V> l) {
      MouseEvent mEvt = (MouseEvent) e;
      int id = mEvt.getID();
      int btn = mEvt.getButton();
      if (id == MouseEvent.MOUSE_PRESSED && btn == MouseEvent.BUTTON1) {
         pressedPt = mEvt.getPoint();
         rect = new Rectangle(pressedPt.x, pressedPt.y, 0, 0);
      }
      if (id == MouseEvent.MOUSE_PRESSED && btn != MouseEvent.BUTTON1) {
         pressedPt = null;
      }
      if (id == MouseEvent.MOUSE_DRAGGED && pressedPt != null) {
         draggedPt = mEvt.getPoint();
         int x = Math.min(draggedPt.x, pressedPt.x);
         int y = Math.min(draggedPt.y, pressedPt.y);
         int width = Math.abs(draggedPt.x - pressedPt.x);
         int height = Math.abs(draggedPt.y - pressedPt.y);
         rect = new Rectangle(x, y, width, height);
      }
      if (id == MouseEvent.MOUSE_RELEASED && pressedPt != null) {
         draggedPt = mEvt.getPoint();
         int x = Math.min(draggedPt.x, pressedPt.x);
         int y = Math.min(draggedPt.y, pressedPt.y);
         int width = Math.abs(draggedPt.x - pressedPt.x);
         int height = Math.abs(draggedPt.y - pressedPt.y);
         rect = new Rectangle(x, y, width, height);
         firePropertyChange(MOUSE_RELEASED, null, rect);
      }      
      l.repaint();
   }
}

@SuppressWarnings("serial")
class Graph2 extends JPanel {
   private static final int MAX_DATA_POINTS = 100;
   private static final int STEP = 10;
   private static final Stroke STROKE = new BasicStroke(3f);
   private Path2D path2D;
   private int width;
   private int height;
   private int[] data = new int[MAX_DATA_POINTS + 1];
   private Random random = new Random();

   public Graph2(int width, int height) {
      this.width = width;
      this.height = height;
      init();

      addComponentListener(new ComponentAdapter() {
         @Override
         public void componentResized(ComponentEvent e) {
            path2D = new Path2D.Double();
            int w = getWidth();
            int h = getHeight();
            double x = 0;
            double y = ((double) MAX_DATA_POINTS - data[0]) * h
                  / MAX_DATA_POINTS;
            path2D.moveTo(x, y);
            for (int i = 1; i < data.length; i++) {
               x = (i * w) / (double) MAX_DATA_POINTS;
               y = ((double) MAX_DATA_POINTS - data[i]) * h
                     / (double) MAX_DATA_POINTS;
               path2D.lineTo(x, y);
            }
         }
      });
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(width, height);
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (path2D != null) {
         Graphics2D g2d = (Graphics2D) g;
         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
         g2d.setStroke(STROKE);
         g2d.draw(path2D);
      }
   };

   private void init() {
      // create and fill random data
      data[0] = 0;
      boolean up = true;
      // max and min data values -- used for normalization
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int i = 1; i < data.length; i++) {
         up = random.nextInt(4) < 3 ? up : !up;
         if (up) {
            data[i] = data[i - 1] + random.nextInt(STEP);
         } else {
            data[i] = data[i - 1] - random.nextInt(STEP);
         }

         if (data[i] > max) {
            max = data[i];
         }
         if (data[i] < min) {
            min = data[i];
         }
      }

      // normalize the data
      for (int i = 0; i < data.length; i++) {
         int datum = (MAX_DATA_POINTS * (data[i] - min)) / (max - min);
         data[i] = datum;
      }

   }
}