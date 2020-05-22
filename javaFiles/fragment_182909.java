Node focusOwner = scene.getFocusOwner();
if (focusOwner instanceof TextField) {
    TextField textField = (TextField) focusOwner ;
    String selectedText = textField.getSelectedText();
    // ...
}