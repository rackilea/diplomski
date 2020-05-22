import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class ClassMain {

   private static void createAndShowGui() {
      ClassMain mainPanel = new ClassMain();

      JFrame frame = new Class1();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

class Class1 extends JFrame {
   private JTextField textfield = new JTextField(10);

   public Class1() {
      JPanel contentPane = (JPanel) getContentPane();
      contentPane.setLayout(new FlowLayout());
      add(textfield);
      add(new JButton(new AbstractAction("Open Window") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            Class2 class2 = new Class2(Class1.this);
            Class1.this.setVisible(false);
            class2.pack();
            class2.setVisible(true);
            class2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }
      }));
   }

   public String getTextfieldText() {
      return textfield.getText();
   }
}

class Class2 extends JFrame {
   private Class1 class1;
   private JLabel label = new JLabel("");

   public Class2(Class1 class1) {
      this.class1 = class1;
      label.setText(class1.getTextfieldText());
      add(label);
   }


}