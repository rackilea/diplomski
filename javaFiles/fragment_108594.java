import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.*;

public class Foo extends JPanel {
   public static final int GRID_SIZE = 10;
   private Point current;
   private JButton[][] grid;

   public Foo() {
      ButtonListener listener = new ButtonListener();
      setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
      grid = new JButton[GRID_SIZE][GRID_SIZE];
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            grid[i][j] = new JButton("   ");
            grid[i][j].addActionListener(listener);
            add(grid[i][j]);
         }
      }

      current = new Point(GRID_SIZE - 1, GRID_SIZE - 1);
   }

   private class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         JButton clicked = (JButton) e.getSource();
         // !! int gs = Integer.parseInt(gridSizeInput.getText());
         int gs = GRID_SIZE;
         // !! for (int i = 0; i < gs - 1; i++) {
         // for (int j = 0; j < gs - 1; j++) {
         for (int i = 0; i < gs; i++) {
            for (int j = 0; j < gs; j++) {

               if (clicked == grid[i][j]) {
                  if (goodMove(i, j)) {
                     System.out.println("TEST");
                     current = new Point(i, j);
                     grid[i][j].setBackground(Color.green);
                     grid[i][j].setText("=");
                  } else {
                     System.out.println("TEST2");
                  }
               }
            }
         }
      }
   }

   public boolean goodMove(int x, int y) {
      int val = Math.abs(current.x - x) + Math.abs(current.y - y);
      return val == 1;
   }

   private static void createAndShowGui() {
      Foo mainPanel = new Foo();
      JFrame frame = new JFrame("Foo");
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