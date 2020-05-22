myTextField.addDataChangedListener((i, ii) -> {
    if(isValidInput(myTextField.getText())) {
       myTextField.putClientProperty("LastValid", myTextField.getText());
    } else {
       myTextField.stopEditing();
       myTextField.setText((String)myTextField.getClientProperty("LastValid"));
       myTextField.startEditingAsync();
    }
});