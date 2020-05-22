Control[] focusOrder = new Control[] {
    fName, lName, birthDay, address, city, 
    telephoneNmbr, email, closeBtn, okBtn};

for (int i = 0 ; i < focusOrder-1 ; i++) {
    Control nextControl = focusOrder[i+1];
    focusOrder[i].addEventHandler(ActionEvent.ACTION, e -> nextControl.requestFocus());
}

okBtn.setOnAction(...);