import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Foo2 {
   public static void main(String[] args) {
      MainApp2 mainApp = new MainApp2();
      mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainApp.pack();
      mainApp.setLocationRelativeTo(null);
      mainApp.setVisible(true);
   }
}

class MainApp2 extends JFrame {
   public MainApp2() {
      getContentPane().add(new DrawingBoard2(this));
   }

   public void mainAppMethod() {
      System.out.println("This is being called from the Main App");
   }
}

class DrawingBoard2 extends JPanel {
   private MainApp2 mainApp;

   public DrawingBoard2(final MainApp2 mainApp) {
      this.mainApp = mainApp;
      JButton button = new JButton("Button");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            buttonActonPerformed();
         }
      });
      add(button);
   }

   private void buttonActonPerformed() {
      mainApp.mainAppMethod();

   }
}