import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OutsideListener2 extends JFrame {
   private JTextField textField = new JTextField(10);
   private JButton showDialogBtn = new JButton("Show Dialog");
   private MyDialog2 myDialog = new MyDialog2(this, "My Dialog");

   public OutsideListener2(String title) {
      super(title);
      textField.setEditable(false);

      showDialogBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (!myDialog.isVisible()) {
               myDialog.setVisible(true);

               textField.setText(myDialog.getTextFieldText());
            }
         }
      });

      JPanel panel = new JPanel();
      panel.add(textField);
      panel.add(showDialogBtn);

      add(panel);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(400, 300);
   }

   private static void createAndShowGui() {
      JFrame frame = new OutsideListener2("OutsideListener");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
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

class MyDialog2 extends JDialog {
   private JTextField textfield = new JTextField(10);
   private JButton confirmBtn = new JButton("Confirm");

   public MyDialog2(JFrame frame, String title) {
      super(frame, title, true); // !!!!! made into a modal dialog
      JPanel panel = new JPanel();
      panel.add(new JLabel("Please enter a number between 1 and 100:"));
      panel.add(textfield);
      panel.add(confirmBtn);

      add(panel);
      pack();
      setLocationRelativeTo(frame);

      ActionListener confirmListener = new ConfirmListener();
      confirmBtn.addActionListener(confirmListener); // add listener
      textfield.addActionListener(confirmListener );
   }

   public String getTextFieldText() {
      return textfield.getText();
   }

   private class ConfirmListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String text = textfield.getText();
         if (isTextValid(text)) {
            MyDialog2.this.setVisible(false);
         } else {
            // show warning
            String warning = "Data entered, \"" + text + 
               "\", is invalid. Please enter a number between 1 and 100";
            JOptionPane.showMessageDialog(confirmBtn,
                  warning,
                  "Invalid Input", JOptionPane.ERROR_MESSAGE);
            textfield.setText("");
            textfield.requestFocusInWindow();
         }
      }
   }

   // true if data is a number between 1 and 100
   public boolean isTextValid(String text) {
      try {
         int number = Integer.parseInt(text);
         if (number > 0 && number <= 100) {
            return true;
         }
      } catch (NumberFormatException e) {
         // one of the few times it's OK to ignore an exception
      }
      return false;
   }

}