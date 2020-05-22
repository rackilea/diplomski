import java.awt.*;
import javax.swing.*;

public class CentralPanel {

   private static void createAndShowGui() {
      JFrame frame = new JFrame("CentralPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MyContentPane());
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

class MyContentPane extends JPanel {
   private static final int PREF_W = 700;
   private static final int PREF_H = 550;

   public MyContentPane() {
      setLayout(new GridBagLayout());
      add(new JPanelOfInterest());
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}

class JPanelOfInterest extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;

   public JPanelOfInterest() {
      setBorder(BorderFactory.createTitledBorder("JPanel of Interest"));
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}