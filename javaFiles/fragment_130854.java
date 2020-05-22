import java.awt.event.*;
import javax.swing.*;

public class StopTimer extends JPanel {
   private static final float FONT_SIZE = 32;
   private Timer myTimer;
   private JLabel timerLabel = new JLabel("000");
   private int count = 0;

   public StopTimer() {
      timerLabel.setFont(timerLabel.getFont().deriveFont(FONT_SIZE));
      add(timerLabel);

      int timerDelay = 1000;
      myTimer = new Timer(timerDelay , new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            count++;
            timerLabel.setText(String.format("%03d", count));
            System.out.println("count: " + count);
         }
      });
      myTimer.start();
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("StopTimer");
      frame.getContentPane().add(new StopTimer());
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