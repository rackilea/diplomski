import java.awt.event.*;
import javax.swing.*;

public class Foo002 extends JPanel implements ActionListener {

   JComboBox combo1 = new JComboBox(new String[]{"Fe", "Fi", "Fo", "Fum"});
   public Foo002() {

      JComboBox combo2 = new JComboBox(new String[]{"One", "Two", "Three", "Four"});
      JButton helloBtn = new JButton("Hello");

      helloBtn.addActionListener(this); // I really hate doing this!

      add(combo1);
      add(combo2);
      add(helloBtn);
   }

   private static void createAndShowGUI() {
      JFrame frame = new JFrame("FormattedTextFieldDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new Foo002());
      frame.pack();
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            createAndShowGUI();
         }
      });
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // this works because combo1 is visible in this method 
      System.out.println(combo1.getSelectedItem().toString());

      // this doesn't work because combo2's scope is limited to 
      // the constructor and it isn't visible in this method.
      System.out.println(combo2.getSelectedItem().toString());
   }

}