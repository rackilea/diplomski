import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Foo1 {
   public static void main(String[] args) {
      MainApp mainApp = new MainApp();
      mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainApp.pack();
      mainApp.setLocationRelativeTo(null);
      mainApp.setVisible(true);
   }
}

class MainApp extends JFrame {
   public MainApp() {
      getContentPane().add(new DrawingBoard());
   }

   public void mainAppMethod() {
      System.out.println("This is being called from the Main App");
   }
}

class DrawingBoard extends JPanel {
   public DrawingBoard() {
      JButton button = new JButton("Button");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            MainApp mainApp = (MainApp) SwingUtilities.getWindowAncestor(DrawingBoard.this);
            mainApp.mainAppMethod();
         }
      });
      add(button);
   }
}