import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Arc2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestArc2D extends JPanel {
   private static final int PREF_W = 1000;
   private static final int PREF_H = 400;
   private static final Stroke STROKE = new BasicStroke(5f);
   private static final Color ARC_COLOR = Color.red;
   private Arc2D arc;

   public TestArc2D() {
      addComponentListener(new ComponentAdapter() {
         @Override
         public void componentResized(ComponentEvent e) {
            double x = 10;
            double y = x;
            double w = getWidth() - 2 * x;
            double h = 2 * getHeight() - 2 * y - 50;
            double start = 0;
            double extent = 180.0;
            arc = new Arc2D.Double(x, y, w, h, start , extent, Arc2D.OPEN);
         }
      });
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setStroke(STROKE);
      g2.setColor(ARC_COLOR);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      if (arc != null) {
         g2.draw(arc);
      }
      g2.dispose();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      TestArc2D mainPanel = new TestArc2D();

      JFrame frame = new JFrame("TestArc2D");
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