import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class GridBagExample {
   private static void createAndShowUI() {
      String[] data = {"one", "two", "three", "four"};

      JPanel panel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1.0;  // **** comment this line out to see effect ****
      gbc.weighty = 1.0;  // **** comment this line out to see effect ****

      for (int i = 0; i < data.length; i++) {
         JLabel label = new JLabel(data[i]);
         gbc.gridy = i;
         panel.add(label, gbc);
      }

      JFrame frame = new JFrame("GridBagExample");
      frame.getContentPane().add(panel);
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