import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyGrid extends JPanel {
   private static final int GRID_LENGTH = 8;
   private static final Color BTN_BACKGROUND = Color.BLACK;
   private static final Color[] COLORS = { Color.MAGENTA, Color.CYAN,
         Color.RED, Color.YELLOW, Color.ORANGE, Color.PINK, Color.BLUE,
         Color.GREEN };
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final int TIMER_DELAY = 800;
   private JButton[][] buttonGrid = new JButton[GRID_LENGTH][GRID_LENGTH];
   private Map<JButton, Color> btnColorMap = new HashMap<>();
   private Random random = new Random();

   public MyGrid() {
      setLayout(new GridLayout(GRID_LENGTH, GRID_LENGTH));
      for (int row = 0; row < buttonGrid.length; row++) {
         for (int col = 0; col < buttonGrid[row].length; col++) {
            JButton btn = new JButton();
            btn.setBackground(BTN_BACKGROUND);
            // !! add action listener here?

            add(btn);
            buttonGrid[row][col] = btn;
         }
      }

      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void resetAllBtns() {
      for (JButton[] row : buttonGrid) {
         for (JButton btn : row) {
            btn.setBackground(BTN_BACKGROUND);
         }
      }
   }

   private class TimerListener implements ActionListener {
      private int row = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
         resetAllBtns(); // make all buttons black

         if (row != buttonGrid.length) {
            for (int c = 0; c < buttonGrid[row].length; c++) {
               int colorIndex = random.nextInt(COLORS.length);
               Color randomColor = COLORS[colorIndex];
               buttonGrid[row][c].setBackground(randomColor);

               // !! not sure if you need this
               btnColorMap.put(buttonGrid[row][c], randomColor);
            }

            row++;
         } else {
            // else we've run out of rows -- stop the timer
            ((Timer) e.getSource()).stop();
         }
      }
   }

   private static void createAndShowGui() {
      MyGrid mainPanel = new MyGrid();

      JFrame frame = new JFrame("MyGrid");
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