import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class MyGui {
   public static void main(String[] args) {
      String[] texts = { "One", "Two", "Three", "Four", "Five" };
      JFrame frame = new JFrame("GUI");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel panel = new JPanel();

      for (int i = 0; i < texts.length; i++) {
         int value = i + 1;
         panel.add(new JButton(new NewAction(value, texts[i])));
      }

      frame.add(panel);

      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
}

class NewAction extends AbstractAction {
   private int value;

   public NewAction(int value, String name) {
      super(name);
      this.value = value;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println("Value: " + value);
   }
}