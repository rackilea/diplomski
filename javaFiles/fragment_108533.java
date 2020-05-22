import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class ColorGrid extends JPanel {
   private static final int PREF_W = 750;
   private static final int PREF_H = 550;
   private static final int GRID_ROWS = 5;
   private static final int GRID_COLS = 5;

   public ColorGrid() {
      JPanel gridPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
      for (int row = 0; row < GRID_ROWS; row++) {
         for (int col = 0; col < GRID_COLS; col++) {
            gridPanel.add(new ColorGridCell(row, col));
         }
      }

      setLayout(new GridBagLayout()); // to center component added
      add(gridPanel);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      ColorGrid mainPanel = new ColorGrid();

      JFrame frame = new JFrame("ColorGrid");
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

@SuppressWarnings("serial")
class ColorGridCell extends JPanel {
   private static final int PREF_W = 100;
   private static final int PREF_H = 75;
   private final static Color[] COLORS = { Color.red, Color.orange,
         Color.yellow, Color.green, Color.blue, Color.cyan, Color.darkGray,
         Color.magenta, Color.pink };
   private int colorIndex = (int) (Math.random() * COLORS.length);
   private int row;
   private int col;

   public ColorGridCell(int row, int col) {
      this.row = row;
      this.col = col;
      setBackground(COLORS[colorIndex]);

      addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            colorIndex++;
            colorIndex %= COLORS.length;
            setBackground(COLORS[colorIndex]);
         }
      });
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public int getRow() {
      return row;
   }

   public int getCol() {
      return col;
   }
}