import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;


@SuppressWarnings("serial")
public class TextTestGui extends JPanel  {
   private JTextField limitedField = new JTextField(10);

   public TextTestGui() {
      add(limitedField);
      PlainDocument doc = (PlainDocument) limitedField.getDocument();
      doc.setDocumentFilter(new MyDocFilter(5));;
   }

   private class MyDocFilter extends DocumentFilter {

      private int limit;

      public MyDocFilter(int limit) {
         this.limit = limit;
      }

      @Override
      public void insertString(FilterBypass fb, int offset, String string,
            AttributeSet attr) throws BadLocationException {
         Document innerDoc = fb.getDocument();
         StringBuilder sb = new StringBuilder(innerDoc.getText(0, innerDoc.getLength()));
         sb.insert(offset, string);
         if (textOK(sb.toString())) {
            super.insertString(fb, offset, string, attr);
         }
      }

      @Override
      public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {
         Document innerDoc = fb.getDocument();
         StringBuilder sb = new StringBuilder(innerDoc.getText(0, innerDoc.getLength()));
         int start = offset; 
         int end = offset + length;
         sb.replace(start, end, text);
         if (textOK(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
         }
      }

      @Override
      public void remove(FilterBypass fb, int offset, int length)
            throws BadLocationException {
         super.remove(fb, offset, length);
      }

      private boolean textOK(String text) {
         if (text.length() <= limit) {
            return true;
         }
         return false;
      }
   }

   private static void createAndShowGui() {
      TextTestGui mainPanel = new TextTestGui();

      JFrame frame = new JFrame("TextTestGui");
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