import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class HandGameGui extends JPanel {
   private JTextArea tArea = new JTextArea(13, 40);

   public HandGameGui() {
      ButtonListener btnListener = new ButtonListener();
      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      for (HandGameChoice hgChoice : HandGameChoice.values()) {
         String choiceString = hgChoice.name();
         String initCapChoiceString = choiceString.substring(0, 1)
               + choiceString.substring(1, choiceString.length()).toLowerCase();

         JButton button = new JButton(initCapChoiceString);
         button.setActionCommand(choiceString);
         button.addActionListener(btnListener);
         btnPanel.add(button);
      }

      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      setLayout(new BorderLayout(5, 5));
      add(new JScrollPane(tArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
      add(btnPanel, BorderLayout.PAGE_END);
   }

   private class ButtonListener implements ActionListener {
      private Random random = new Random();
      @Override
      public void actionPerformed(ActionEvent e) {
         String actionCommand = e.getActionCommand();
         HandGameChoice userChoice = HandGameChoice.valueOf(actionCommand);
         int randomInt = random.nextInt(HandGameChoice.values().length);
         HandGameChoice aiChoice = HandGameChoice.values()[randomInt];

         int gameResult = HandGameChoice.compare(userChoice, aiChoice);
         String resultStr = "";
         if (gameResult > 0) {
            resultStr = "win";
         } else if (gameResult < 0) {
            resultStr = "lose";
         } else {
            resultStr = "tie";
         }

         String output = String.format("You chose %s, and the computer chose %s; you %s%n", 
               userChoice, aiChoice, resultStr);
         tArea.append(output);
      }
   }

   private static void createAndShowGui() {
      HandGameGui mainPanel = new HandGameGui();

      JFrame frame = new JFrame("Rock Paper Scissors Lizard Spock");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
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