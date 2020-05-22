import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Pacmania extends JPanel {
   private static final String TITLE_TEXT = "Pacmania";
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final Color BACKGROUND = Color.black;
   private static final Color FOREGROUND = Color.green;
   private static final Font TITLE_FONT = new Font(Font.SERIF, Font.BOLD, 46);
   private static final int I_GAP = 10;

   public Pacmania() {
      setBackground(BACKGROUND);
      setLayout(new GridBagLayout());

      JLabel label = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
      label.setFont(TITLE_FONT);
      label.setForeground(FOREGROUND);

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.insets = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);
      add(label, gbc);

      JButton newGameButton = new JButton(new NewGameAction("New Game"));
      gbc.gridy = 1;
      newGameButton.setBackground(BACKGROUND);
      newGameButton.setForeground(FOREGROUND);
      newGameButton.setBorderPainted(false);
      newGameButton.setFocusPainted(false);
      add(newGameButton, gbc);

   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class NewGameAction extends AbstractAction {
      public NewGameAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Finish this!
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Pacmania");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Pacmania());
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