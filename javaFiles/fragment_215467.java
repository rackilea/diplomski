import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.*;

public class Test {

   public void initComponents() {

      JPanel panel = new JPanel();
      final MyDocumentFilter myFilter = new MyDocumentFilter();
      final JTextField myArea = new JTextField(20);
      ((AbstractDocument) myArea.getDocument()).setDocumentFilter(myFilter);

      panel.add(myArea);

      panel.add(new JButton(new AbstractAction("Set Text") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            myFilter.setFiltering(false);
            myArea.setText("Fe Fi Fo Fum");
            myFilter.setFiltering(true);
         }
      }));

      JOptionPane.showMessageDialog(null, panel);

      // add components set frame visible
   }

   public static void main(String[] args) {
      new Test().initComponents();
   }

}

class MyDocumentFilter extends DocumentFilter {
   private boolean filtering = true;

   @Override
   public void replace(FilterBypass fb, int i, int i1, String string,
         AttributeSet as) throws BadLocationException {
      if (!filtering) {
         super.replace(fb, i, i1, string, as);
      }
   }

   @Override
   public void remove(FilterBypass fb, int i, int i1)
         throws BadLocationException {
      int offset = 0;
      int length = fb.getDocument().getLength();
      super.remove(fb, offset, length);
   }

   @Override
   public void insertString(FilterBypass fb, int i, String string,
         AttributeSet as) throws BadLocationException {
      if (!filtering) {
         super.insertString(fb, i, string, as);         
      }
   }

   public void setFiltering(boolean filtering) {
      this.filtering = filtering;
   }

}