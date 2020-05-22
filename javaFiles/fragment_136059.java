import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WaitForInput extends JPanel {
   private JTextField field1 = new JTextField(5);
   private JTextField field2 = new JTextField(5);
   private JTextField sumField = new JTextField(5);
   private JButton addButton = new JButton("Add");

   public WaitForInput() {
      addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String text1 = field1.getText().trim();
            String text2 = field2.getText().trim();

            if (text1.isEmpty() || text2.isEmpty()) {
               // data not entered... so return the method and do nothing
               return;
            }

            try {
               int number1 = Integer.parseInt(field1.getText());
               int number2 = Integer.parseInt(field2.getText());
               int sum = number1 + number2;

               sumField.setText("" + sum);
            } catch (NumberFormatException e1) {
               // TODO: use JOptionPane to send error message

               // clear the fields
               field1.setText("");
               field2.setText("");
            }
         }
      });

      add(field1);
      add(new JLabel("+"));
      add(field2);
      add(new JLabel("="));
      add(sumField);
      add(addButton);
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("WaitForInput");
      frame.getContentPane().add(new WaitForInput());
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