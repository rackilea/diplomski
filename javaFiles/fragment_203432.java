tf.getDocument().addDocumentListener(new DocumentListener() {
public void changedUpdate(DocumentEvent e) {
    printIt();
}
public void removeUpdate(DocumentEvent e) {
    printIt();
}
public void insertUpdate(DocumentEvent e) {
    printIt();
}

public void printIt() {
    System.out.println(tf.getText());
}