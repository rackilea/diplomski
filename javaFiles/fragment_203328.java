import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ElevatorTest {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;

   private static void createAndShowGui() {
      MyElevator mainPanel = new MyElevator(PREF_W, PREF_H);

      JFrame frame = new JFrame("Elevator Test");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      // start everything on the Swing event thread
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class MyElevator extends JPanel {
   private static final Color BACKGROUND = Color.white;
   private static final int ELEVATOR_X = 200;
   private static final int ELEVATOR_W = 40;
   private static final int ELEVATOR_H = 60;
   private static final int TIMER_DELAY = 50;
   public static final int MAX_ELEVATOR_Y = 130;
   private static final Color ELEVATOR_COLOR = Color.blue;
   private int prefW;
   private int prefH;
   private int elevatorY = 0;

   public MyElevator(int prefW, int prefH) {
      this.prefW = prefW;
      this.prefH = prefH;
      setBackground(BACKGROUND);

      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      // Don't forget to call the super method
      super.paintComponent(g);

      g.setColor(ELEVATOR_COLOR);
      g.fillRect(ELEVATOR_X, elevatorY, ELEVATOR_W, ELEVATOR_H);
   }

   // to help size our GUI properly
   @Override
   public Dimension getPreferredSize() {
      Dimension superSz = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSz;
      }
      int w = Math.max(superSz.width, prefW);
      int h = Math.max(superSz.height, prefH);
      return new Dimension(w, h);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if (elevatorY >= MAX_ELEVATOR_Y) {
            // if elevator at max, stop thimer
            ((Timer) e.getSource()).stop();
         } else {
            // advance elevator and draw it
            elevatorY++;
            repaint();
         }
      }
   }
}