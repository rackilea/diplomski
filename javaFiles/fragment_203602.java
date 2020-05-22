import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Disenos2 extends JPanel {
   public static final int ROWS = 6;
   public static final int COLUMNS = 7;

   private JButton[][] botones = new JButton[ROWS][COLUMNS];
   private boolean redTurn = true;

   public Disenos2() {
      ButtonAction buttonAction = new ButtonAction();
      setLayout(new GridLayout(ROWS, COLUMNS, 5, 5));
      for (int row = 0; row < botones.length; row++) {
         for (int col = 0; col < botones[row].length; col++) {
            JButton boton = new JButton("      ");
            boton.addActionListener(buttonAction);
            add(boton);
            botones[row][col] = boton;
         }
      }
   }

   private class ButtonAction implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         JButton boton = (JButton) e.getSource();
         int column = -1;
         for (int row = 0; row < botones.length; row++) {
            for (int col = 0; col < botones[row].length; col++) {
               if (boton == botones[row][col]) {
                  column = col;
               }
            }
         }

         for (int row = ROWS - 1; row >= 0; row--) {
            Color bkgd = botones[row][column].getBackground();
            if (!isColorSelected(botones[row][column])) {
               Color c = redTurn ? Color.red : Color.black;
               botones[row][column].setBackground(c);
               redTurn = !redTurn;
               break;
            }
         }
      }

      private boolean isColorSelected(JButton jButton) {
         Color c = jButton.getBackground();
         if (Color.red.equals(c)) {
            return true;
         }
         if (Color.black.equals(c)) {
            return true;
         }
         return false;
      }
   }

   private static void createAndShowGui() {
      Disenos2 mainPanel = new Disenos2();

      JFrame frame = new JFrame("Disenos2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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