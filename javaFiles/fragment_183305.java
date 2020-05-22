import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OutsideListener extends JFrame {
   private JTextField textField = new JTextField(10);
   private JButton showDialogBtn = new JButton("Show Dialog");
   private MyDialog myDialog = new MyDialog(this, "My Dialog");

   public OutsideListener(String title) {
      super(title);
      textField.setEditable(false);

      showDialogBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (!myDialog.isVisible()) {
               myDialog.setVisible(true);
            }
         }
      });

      // !! add a listener to the dialog's button
      myDialog.addConfirmListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String text = myDialog.getTextFieldText();
            textField.setText(text);
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
      JFrame frame = new OutsideListener("OutsideListener");
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

class MyDialog extends JDialog {
   private JTextField textfield = new JTextField(10);
   private JButton confirmBtn = new JButton("Confirm");

   public MyDialog(JFrame frame, String title) {
      super(frame, title, false);
      JPanel panel = new JPanel();
      panel.add(textfield);
      panel.add(confirmBtn);

      add(panel);
      pack();
      setLocationRelativeTo(frame);
   }

   public String getTextFieldText() {
      return textfield.getText();
   }

   public void addConfirmListener(ActionListener listener) {
      confirmBtn.addActionListener(listener);
   }
}