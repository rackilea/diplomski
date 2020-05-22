import javax.swing.*;
import javax.swing.text.*;

public class DocListenerEg extends JPanel {
   private static final int FIELD_COUNT = 5;
   private JTextField[] fields = new JTextField[FIELD_COUNT];

   public DocListenerEg() {
      MyDocFilter myFilter = new MyDocFilter();
      for (int i = 0; i < fields.length; i++) {
         fields[i] = new JTextField(5);
         ((PlainDocument) fields[i].getDocument()).setDocumentFilter(myFilter);
         add(fields[i]);
      }
   }

   private class MyDocFilter extends DocumentFilter {
      public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String text, AttributeSet attr) throws BadLocationException {
         for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
               return;
            }
         }
         fb.insertString(offset, text.toUpperCase(), attr);
      }

      public void replace(DocumentFilter.FilterBypass fb, int offset,
            int length, String text, AttributeSet attrs)
            throws BadLocationException {
         for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
               return;
            }
         }
         fb.replace(offset, length, text.toUpperCase(), attrs);
      }
   }

   private static void createAndShowGui() {
      DocListenerEg mainPanel = new DocListenerEg();

      JFrame frame = new JFrame("DocListenerEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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