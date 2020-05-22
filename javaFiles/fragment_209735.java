import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChangingArcs extends JPanel {
   private static final Color ARC_FILL_COLOR = Color.RED;
   private static final int TIMER_DELAY = 20;
   private static final int ARC_X = 100;
   private static final int ARC_Y = 100;
   private static final int ARC_W = 500;
   private static final int ARC_H = 500;
   protected static final double DELTA_EXTEND = 0.5;
   private Arc2D arc;
   private double extend = 0;

   public ChangingArcs() {
      new Timer(TIMER_DELAY, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            extend += DELTA_EXTEND;
            extend %= 360;
            double start = -extend/2;
            arc = new Arc2D.Double(ARC_X, ARC_Y, ARC_W, ARC_H, start, extend, Arc2D.PIE);
            repaint();
         }
      }).start();
   }

   public Dimension getPreferredSize() {
      return new Dimension(ARC_W + 2 * ARC_X, ARC_H + 2 * ARC_Y);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      if (arc != null) {
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setColor(ARC_FILL_COLOR);
         g2.fill(arc);
      }
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("ChangingArcs");
      frame.getContentPane().add(new ChangingArcs());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
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