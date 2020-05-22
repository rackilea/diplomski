import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HaltingProblem extends JPanel {
   private static final int PANEL_HEIGHT = 400;
   private static final int PANEL_WIDTH = 600;
   private static final long SLEEP_DELAY = 100;
   private Color[] colors = {Color.red, Color.orange, Color.yellow,
      Color.green, Color.blue, Color.cyan};
   private boolean halt = false;
   private JButton haltButton = new JButton("Halt");
   private int colorIndex = 0;

   public HaltingProblem() {
      setBackground(colors[colorIndex]);
      haltButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            halt = !halt; // toggle it!
         }
      });
      add(haltButton);

      new Thread(new Runnable() {
         public void run() {
            while (true) {
               keepDoingThis();
            }
         }
      }).start();
   }

   private void keepDoingThis() {
      try {
         Thread.sleep(SLEEP_DELAY);
      } catch (InterruptedException e) {}

      if (halt) {
         return;
      }
      colorIndex++;
      colorIndex %= colors.length;
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            setBackground(colors[colorIndex]);
         }
      });
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("HaltingProblem");
      frame.getContentPane().add(new HaltingProblem());
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