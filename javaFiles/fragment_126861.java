import javax.swing.JDialog;
import javax.swing.JFrame;

public class DialogAndDaemons {
   public static void main(String[] args) {
      JFrame frame = new JFrame();

      JDialog dialog = new JDialog(frame, "Dialog");
      dialog.pack();
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
   }
}