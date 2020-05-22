import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class LarsonScanner extends JPanel {
   private static final int PANEL_COUNT = 40;
   private static final int TIMER_DELAY = 20;
   private static final Color BACKGROUND = Color.BLACK;
   private static final Color ACTIVE_COLOR = Color.GREEN;
   private static final Color PARTIAL_COLOR = new Color(0, 90, 0);
   private static final Dimension RIGID_AREA = new Dimension(14, 1);

   private JPanel[] panels = new JPanel[PANEL_COUNT];

   public LarsonScanner() {
      setLayout(new GridLayout(1, 0));
      for (int i = 0; i < panels.length; i++) {
         panels[i] = new JPanel();
         panels[i].add(Box.createRigidArea(RIGID_AREA));
         panels[i].setBackground(BACKGROUND);
         add(panels[i]);
      }
      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   private class TimerListener implements ActionListener {
      private int count = 0;
      private boolean goingRight = true;

      @Override
      public void actionPerformed(ActionEvent e) {
         if (goingRight) {
            int index = (count - 2 + panels.length) % panels.length;
            panels[index].setBackground(BACKGROUND);
            int prior = Math.max((count - 1) % panels.length, 0);
            int next = Math.min(count + 1, panels.length - 1);
            panels[prior].setBackground(PARTIAL_COLOR);
            panels[next].setBackground(PARTIAL_COLOR);
            panels[count].setBackground(ACTIVE_COLOR);
            count++;
            if (count == panels.length) {
               count--;
               goingRight = false;
            }
         } else {
            int index = (count + 2) % panels.length;
            panels[index].setBackground(BACKGROUND);
            int prior = Math.max((count - 1) % panels.length, 0);
            int next = Math.min(count + 1, panels.length - 1);
            panels[prior].setBackground(PARTIAL_COLOR);
            panels[next].setBackground(PARTIAL_COLOR);
            panels[count].setBackground(ACTIVE_COLOR);
            count--;
            if (count == -1) {
               count++;
               goingRight = true;
            }
         }
      }
   }

   private static void createAndShowGui() {
      LarsonScanner mainPanel = new LarsonScanner();

      JFrame frame = new JFrame("LarsonScanner");
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