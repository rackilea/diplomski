String firstNameValue = firstNameInput.getText();
if (firstNameValue.equals("")){
    System.out.printf("Please input first name!");
}
else{
    firstNameValue = gi.getFirstName();
}