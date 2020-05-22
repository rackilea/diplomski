import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.*;

public class UpdatePane2 extends JPanel {
   private static final int PREF_W = 300;
   private static final int PREF_H = 200;

   public UpdatePane2() {
      JPanel innerPanel = new JPanel();
      innerPanel.setLayout(new BorderLayout());
      innerPanel.add(new JLabel("Hi Mom", SwingConstants.CENTER), 
            BorderLayout.NORTH);
      innerPanel.add(new JButton("Click Me"), BorderLayout.CENTER);

      setLayout(new GridBagLayout());
      add(innerPanel);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("UpdatePane2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new UpdatePane2());
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