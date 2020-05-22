JTextArea destTextArea;
public superclass(String string, JTextArea pDestTextArea) {
    destTextArea = pDestTextArea;
}
....
public void actionPerformed(ActionEvent event){
    if ((event.getSource() == status) && (destTextArea != null)) {
        destTextArea.setText(get.getText());
    }
}