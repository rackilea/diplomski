userNameTextBox.getDocument().addDocumentListener(new DocumentListener(){

    @Override
    public void insertUpdate(DocumentEvent e) {
        handleTextChange();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handleTextChange();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        //Do nothing here
    }

    private void handleTextChange(){
        if(userNameTextBox.getText() == null ||
            userNameTextBox.getText().trim().length() == 0){
            passwordBox.setEnabled(false);
        }else{
            passwordBox.setEnabled(true);
        }
    }

});