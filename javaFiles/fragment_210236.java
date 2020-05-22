import java.awt.*;
import java.lang.reflect.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.*;

public class Main {

 public static void main(String[] args)
   throws InterruptedException, InvocationTargetException {

  SwingUtilities.invokeAndWait(new Runnable() {

   @Override
   public void run() {
    try {
     UIManager.setLookAndFeel(new NimbusLookAndFeel() {

      @Override
      public UIDefaults getDefaults() {
       UIDefaults ret = super.getDefaults();
       ret.put("defaultFont",
         new Font(Font.MONOSPACED, Font.BOLD, 16)); // supersize me
       return ret;
      }

     });

     new JFrame("Hello") {

      {
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new FlowLayout(FlowLayout.LEFT));

       setSize(500, 500);
       setLocationRelativeTo(null);

       add(new JLabel("someLabel 1"));
       add(new JButton("someButton 1"));
       add(new JLabel("someLabel 2"));
       add(new JButton("someButton 2"));

       setVisible(true);
      }

     };     
    } catch (Exception ex) {
     throw new Error(ex);
    }
   }

  });
 }

}