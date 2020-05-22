import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class QuickTimerEg extends JPanel {
   private static final int TIMER_DELAY = 2000;
   private boolean buttonsWorking = true;
   private JButton btn1 = null;
   private JButton btn2 = null;
   private Timer swingTimer;

   public QuickTimerEg() {
      ActionListener btnListener = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btnActionPerformed(e);
         }
      };
      setLayout(new GridLayout(4, 4));
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            JButton button = new JButton("   ");
            button.addActionListener(btnListener);
            add(button);
         }
      }
   }

   private void btnActionPerformed(ActionEvent e) {
      if (!buttonsWorking) {
         return;
      }
      JButton button = (JButton)e.getSource();
      button.setBackground(Color.blue);
      button.setEnabled(false);
      if (btn1 == null) {
         btn1 = button;
      } else {
         buttonsWorking = false;
         btn2 = button;
         swingTimer = new Timer(TIMER_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               btn1.setBackground(null);
               btn2.setBackground(null);
               btn1.setEnabled(true);
               btn2.setEnabled(true);
               btn1 = null;
               btn2 = null;
               buttonsWorking = true;               
            }
         });
         swingTimer.setRepeats(false);
         swingTimer.start();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("QuickTimerEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new QuickTimerEg());
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