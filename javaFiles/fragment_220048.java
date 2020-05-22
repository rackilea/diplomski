import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class RandomRect extends JPanel {
   private static final int MAX_INT = 100;
   private static final Color RECT_COLOR = Color.black;
   private Random random = new Random();
   private int randomX;
   private int randomY;

   public RandomRect() {
      randomX = random.nextInt(MAX_INT);
      randomY = random.nextInt(MAX_INT);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(RECT_COLOR);
      g.fillRect(randomX, randomY, MAX_INT, MAX_INT);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("RandomRect");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new RandomRect());
      //frame.pack();
      // frame.setLocationRelativeTo(null);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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