import java.awt.Dialog.ModalityType;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RelinquishControl {
   public static void main(String[] args) {
      JTextField textField = new JTextField("Fubar", 15);
      textField.selectAll();
      JPanel panel = new JPanel();
      panel.add(textField);
      final JFrame frame = new JFrame("Frame");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      textField = new JTextField("Fubar", 15);
      textField.selectAll();
      panel = new JPanel();
      panel.add(textField);
      final JDialog dialog = new JDialog(frame, "Dialog", ModalityType.MODELESS);
      dialog.add(panel);
      dialog.pack();
      int x = frame.getLocation().x + 200;
      int y = frame.getLocation().y + 200;
      dialog.setLocation(x, y);
      dialog.setVisible(true);

      frame.toFront();
   }
}