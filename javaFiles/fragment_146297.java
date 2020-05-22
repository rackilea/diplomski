import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * http://stackoverflow.com/a/22714405/522444
 * http://stackoverflow.com/questions/22712655/repaint-in-panel-method-not-updated
 * @author Pete
 *
 */
@SuppressWarnings("serial")
public class TimerCircles extends JPanel {
   private static final int PREF_W = 1000;
   private static final int PREF_H = 700;
   private static final Color CIRCLE_COLOR = Color.RED;
   public static final int MAX_CIRCLE_INDEX = 11;
   public static final int TIMER_DELAY = 300;
   public static final int CIRCLE_WIDTH = 100;
   private final List<Ellipse2D> ellipseList = new ArrayList<>();
   private int currentCirclesToDraw = 0;

   public TimerCircles() {
      add(new JButton(new ButtonAction("New Circle", KeyEvent.VK_C)));
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(CIRCLE_COLOR);
      for (int i = 0; i < currentCirclesToDraw && i < ellipseList.size(); i++) {
         g2.fill(ellipseList.get(i));
      }
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      public void actionPerformed(java.awt.event.ActionEvent arg0) {
         currentCirclesToDraw = 0;  // this is key -- reset the index used to control how many circles to draw
         if (ellipseList.size() < MAX_CIRCLE_INDEX) {
            double x = (ellipseList.size()) * CIRCLE_WIDTH / Math.pow(2, 0.5);
            double y = x;
            double w = CIRCLE_WIDTH;
            double h = CIRCLE_WIDTH;
            ellipseList.add(new Ellipse2D.Double(x, y, w, h));
         }
         repaint(); // clear image
         new Timer(TIMER_DELAY, new TimerListener()).start();
      };
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if (currentCirclesToDraw < ellipseList.size()) {
            currentCirclesToDraw++;
            repaint();
         } else {
            // stop the Timer
            ((Timer)e.getSource()).stop();
         }
      }
   }

   private static void createAndShowGui() {
      TimerCircles mainPanel = new TimerCircles();

      JFrame frame = new JFrame("TimerCircles");
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