jTextField.getDocument().addDocumentListener(new DocumentListener() {

@Override
public void insertUpdate(DocumentEvent e) {
    try {
        int value = Integer.parseInt(jTextField.getText());
        field.setInt(A.this, value);
    } catch (NumberFormatException e1) {
    } catch (IllegalArgumentException e1) {
    } catch (IllegalAccessException e1) {
    }
}

......
});