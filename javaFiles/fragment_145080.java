import java.awt.*;
import javax.swing.*;

public class MenuViewSSCCE {
   private static final Dimension APP_SIZE = new Dimension(500, 400);

   private static void createAndShowUI() {
      JTextArea label = new JTextArea(400, 500); // friggin big!
      JTextArea label2 = new JTextArea(400, 500); // friggin big!
      label.setText("Look at how big this JTextArea is!");
      label2.setText("Look at how big this JTextArea is!");

      JPanel centerPanel = new JPanel();
      centerPanel.setPreferredSize(APP_SIZE);
      centerPanel.setLayout(new FlowLayout()); // this line is redundant 
      centerPanel.add(label);

      JScrollPane myScrollpane = new JScrollPane(label2);
      myScrollpane.setPreferredSize(APP_SIZE);

      JPanel gridPanel = new JPanel(new GridLayout(1, 0));
      gridPanel.add(centerPanel);
      gridPanel.add(myScrollpane);

      JFrame frame = new JFrame("Your code on left, mine on right");
      frame.getContentPane().add(gridPanel, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}