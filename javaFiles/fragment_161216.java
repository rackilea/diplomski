import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class Layouts {
   private static final int TF_COLS = 8;

   private static void createAndShowGui() {
      JPanel borderLayoutPanel = new JPanel(new BorderLayout());
      borderLayoutPanel.setBorder(BorderFactory
            .createTitledBorder("BorderLayout Panel"));

      borderLayoutPanel.add(createInnerPanel("North"), BorderLayout.PAGE_START);

      borderLayoutPanel.add(createInnerPanel("North"), BorderLayout.PAGE_START);
      borderLayoutPanel.add(createInnerPanel("South"), BorderLayout.PAGE_END);
      borderLayoutPanel.add(createInnerPanel("East"), BorderLayout.LINE_END);
      borderLayoutPanel.add(createInnerPanel("West"), BorderLayout.LINE_START);

      JPanel centerPanel = new JPanel(new GridLayout(2, 1));
      centerPanel.add(new JLabel());

      JPanel gblPanel = new JPanel(new GridBagLayout());
      gblPanel.add(new JLabel("Question 1:"), createGbc(0, 0));
      gblPanel.add(new JTextField(TF_COLS), createGbc(1, 0));
      gblPanel.add(new JLabel("Question 2:"), createGbc(0, 2));
      gblPanel.add(new JTextField(TF_COLS), createGbc(1, 2));

      centerPanel.add(gblPanel);

      borderLayoutPanel.add(centerPanel);

      JFrame frame = new JFrame("Layouts");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(borderLayoutPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   private static GridBagConstraints createGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      int iGap = 5;
      gbc.insets = (x == 0) ? new Insets(iGap, iGap, iGap, 3 * iGap) : new Insets(
            iGap, iGap, iGap, iGap);
      return gbc;
   }

   private static JComponent createInnerPanel(String text) {
      JPanel panel = new JPanel();
      panel.add(new JLabel(text));
      panel.setBorder(BorderFactory.createEtchedBorder());
      return panel;
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}