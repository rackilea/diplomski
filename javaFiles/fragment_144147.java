import java.awt.Dimension;
import javax.swing.*;

public class TestJDialog {
   private static void createAndShowGui() {
      JDialog dialog = new JDialog((JFrame)null, "Test JDialog", true);

      // Using rigid area just to give the dialog size, but you
      // could put any complex GUI in a JPanel in here
      dialog.getContentPane().add(Box.createRigidArea(new Dimension(400, 400)));
      dialog.pack();
      dialog.setLocationByPlatform(true);
      dialog.setVisible(true);
      System.exit(0); // to end Swing event thread
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}