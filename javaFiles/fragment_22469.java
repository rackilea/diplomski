import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class Ken2 {
   private static final String[][] NUMBERS = {
      {"1", "2", "3"},
      {"4", "5", "6"},
      {"7", "8", "9"},
      {"0"}
   };
   private static final float BUTTON_FONT_PTS = 45f;
   private static final int INSETS = 20;
   private static final Insets BUTTON_INSETS = new Insets(INSETS, INSETS, 
           INSETS, INSETS);
   private static final int IPAD = 20;
   private JPanel mainPanel = new JPanel();

   public Ken2() {
      mainPanel.setLayout(new GridBagLayout());
      for (int row = 0; row < NUMBERS.length; row++) {
         addRowToPanel(row, NUMBERS[row]);
      }
   }

   private void addRowToPanel(int row, String[] numbersRow) {
      int columns = numbersRow.length;
      for (int col = 0; col < numbersRow.length; col++) {
         addNumberButton(row, col, columns, numbersRow[col]);
      }
   }

   private void addNumberButton(int row, int col, int columns, 
           String numberText) {
      JButton button = new JButton(numberText);
      button.setFont(button.getFont().deriveFont(Font.BOLD, BUTTON_FONT_PTS));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = col;
      gbc.gridy = row;
      gbc.gridheight = 1;
      gbc.gridwidth = 3 / columns;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = BUTTON_INSETS;
      gbc.ipadx = IPAD;
      gbc.ipady = IPAD;

      mainPanel.add(button, gbc);
   }

   private static void createAndShowGui() {
      Ken2 ken = new Ken2();

      JFrame frame = new JFrame("Ken2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(ken.getMainPanel());
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   private Component getMainPanel() {
      return mainPanel;
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}