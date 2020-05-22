import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Grid {
   private static final int TIMER_DELAY = 200;
   private int current_x;
   private int current_y;
   private TestPane testPane = new TestPane();
   private Random random = new Random();

   public Grid() {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            // !! frame.add(new TestPane());
            frame.add(testPane); // !!
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
         }
      });
      new Timer(TIMER_DELAY, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            current_x = random.nextInt(TestPane.MAX_X);
            current_y = random.nextInt(TestPane.MAX_Y);
            testPane.setGridX(current_x);
            testPane.setGridY(current_y);
            testPane.repaint();
         }
      }).start();
   }

   public void getCurrentValues(int x, int y) {
      this.current_x = x;
      this.current_y = y;
   }

   public static void main(String[] args) {
      new Grid();
   }
}

class TestPane extends JPanel {
   public static final int MAX_X = 8;
   public static final int MAX_Y = MAX_X;
   private static final int CELL_WIDTH = 50;
   private static final int PREF_W = CELL_WIDTH * MAX_X;
   private static final int PREF_H = CELL_WIDTH * MAX_Y;
   private static final Color FILL_COLOR = Color.yellow;
   private static final Color GRID_COLOR = Color.black;
   private int gridX = -1;
   private int gridY = -1;

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (int y = 0; y < MAX_Y; y++) {
         for (int x = 0; x < MAX_X; x++) {
            if (x == gridX && y == gridY) {
               g.setColor(FILL_COLOR);
               g.fillRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
            }
            g.setColor(GRID_COLOR);
            g.drawRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
         }
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public int getGridX() {
      return gridX;
   }

   public void setGridX(int gridX) {
      this.gridX = gridX;
   }

   public int getGridY() {
      return gridY;
   }

   public void setGridY(int gridY) {
      this.gridY = gridY;
   }
}