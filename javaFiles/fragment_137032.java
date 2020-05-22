import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CloseOptionPane {

   @SuppressWarnings("serial")
   private static void createAndShowGui() {
      final JLabel label = new JLabel();
      int timerDelay = 1000;
      new Timer(timerDelay , new ActionListener() {
         int timeLeft = 5;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (timeLeft > 0) {
               label.setText("Closing in " + timeLeft + " seconds");
               timeLeft--;
            } else {
               ((Timer)e.getSource()).stop();
               Window win = SwingUtilities.getWindowAncestor(label);
               win.setVisible(false);
            }
         }
      }){{setInitialDelay(0);}}.start();

      JOptionPane.showMessageDialog(null, label);

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}