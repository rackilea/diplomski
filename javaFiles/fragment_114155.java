import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class BoxyTest {

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Boxy Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new BoxyPanel(200, 300));
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

@SuppressWarnings("serial")
class BoxyPanel extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 650;
   private int myX;
   private int myY;

   public BoxyPanel(int myX, int myY) {
      this.myX = myX;
      this.myY = myY;
   }

   @Override // so my JPanel will be big enough to see
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      // call super method so that the JPanel can do housekeeping painting
      super.paintComponent(g);
      g.fillRect(myX, myY, 100, 100);
      g.setColor(Color.WHITE);
      g.fillRect(myX + 10, myY + 10, 80, 80);
   }
}