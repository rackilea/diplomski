import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


public class Main2 extends JPanel {
   private JButton testButton = new JButton("Test");
   private JTextField textField = new JTextField(11);

   public Main2() {
      add(testButton);
      add(textField);

      testButton.setEnabled(false);
      textField.getDocument().addDocumentListener(new DocumentListener() {

         @Override
         public void removeUpdate(DocumentEvent e) {
            checkDoc(e);
         }

         @Override
         public void insertUpdate(DocumentEvent e) {
            checkDoc(e);
         }

         @Override
         public void changedUpdate(DocumentEvent e) {
            checkDoc(e);
         }

         private void checkDoc(DocumentEvent e) {
            Document doc = e.getDocument();
            testButton.setEnabled(doc.getLength() > 0);
         }
      });
   }

   private static void createAndShowGui() {
      Main2 mainPanel = new Main2();

      JFrame frame = new JFrame("Main2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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