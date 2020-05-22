myTextField.addDataChangedListener((i, ii) -> {
    if(isValidInput(myTextField.getText())) {
       lastValidInput = myTextField.getText();
    } else {
       myTextField.stopEditing();
       myTextField.setText(lastValidInput);
       myTextField.startEditingAsync();
    }
});