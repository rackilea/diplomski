import java.awt.*;
import javax.swing.*;

public class TestController extends JPanel {
   private static final int PREF_W = 1000;
   private static final int PREF_H = 800;
   TestView cgView;

   public TestController() {
      setLayout(null);
      cgView = new TestView();
      cgView.setSize(getPreferredSize());
      add(cgView);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame fr = new JFrame("testt");
            // fr.setSize(1200, 1000);
            fr.setResizable(false);
            TestController cgc = new TestController();
            fr.setBackground(Color.white);
            // fr.setVisible(true);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.add(cgc);
            fr.pack(); //!! added 
            fr.setVisible(true); // !! moved
         }
      });
   }
}