public class ExtendedJSpinner extends JSpinner {

public ExtendedJSpinner(){

}

public ExtendedJSpinner(SpinnerModel model){
    super(model);
}

@Override
public void setEditor(JComponent editor){

    super.setEditor(editor);

    JFormattedTextField textField = (JFormattedTextField) editor.getComponent(0);

    final JSpinner obj = this;

    // Listen for changes in the text
    textField.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {}
        public void removeUpdate(DocumentEvent e) {}
        public void insertUpdate(DocumentEvent e) {
            String text = textField.getText();

            try {
                float number = Float.valueOf(text).floatValue();
                obj.setValue(number);
            }
            catch(Exception ex) {
                System.out.println("insert failed: " + textField.getText());
            }
        }
    });


}