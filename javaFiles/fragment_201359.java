import java.awt.Dimension;

import javax.swing.*;

public class ShowGetPreferredSize extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;

   @Override
   public Dimension getPreferredSize() {
      Dimension superSize = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSize;
      }
      int w = Math.max(superSize.width, PREF_W);
      int h = Math.max(superSize.height, PREF_H);
      return new Dimension(w, h);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("ShowGetPreferredSize");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(new ShowGetPreferredSize());
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