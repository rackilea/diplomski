import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ShrinkingGui extends JPanel {
   private static final int INIT_W = 400;
   private static final int INIT_H = INIT_W;
   private static final int TIMER_DELAY = 20;
   private int prefW = INIT_W;
   private int prefH = INIT_H;

   public ShrinkingGui() {
      new Timer(TIMER_DELAY, new TimerListener()).start();;
   }

   public Dimension getPreferredSize() {
      return new Dimension(prefW, prefH);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if (prefW > 0 && prefH > 0) {
            prefW--;
            prefH--;
            Window win = SwingUtilities.getWindowAncestor(ShrinkingGui.this);
            win.pack();
         } else {
            ((Timer)e.getSource()).stop();
         }
      }
   }

   private static void createAndShowGUI() {
      ShrinkingGui paintEg = new ShrinkingGui();

      JFrame frame = new JFrame("Shrinking Gui");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(paintEg);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}