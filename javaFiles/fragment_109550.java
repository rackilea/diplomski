final TextField password = new TextField("","Pass Word",15,TextField.PASSWORD);
CheckBox maskAndUnmaskCheck = new CheckBox();
maskAndUnmaskCheck.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(maskAndUnmaskCheck.isSelected()){
           password.setConstraint(TextField.ANY); 
        } else {
            password.setConstraint(TextField.PASSWORD);
        }
        if(password.isEditing()) {
            password.stopEditing();
            password.startEditingAsync();
        } else {
            password.getParent().revalidate(); 
        }
    }
});