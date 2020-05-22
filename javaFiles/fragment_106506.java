else if(event.getSource() == loginSubmitButton){
        DBAccess loginCheck = new DBAccess(); // invoke constructor
        String selFromTable = "SELECT PASSWORD FROM USERS WHERE USERNAME = '" + loginUsername.getText() + "'; ";
        loginCheck.getStatement().execute(selFromTable);
        ResultSet retrievedPassword = loginCheck.getStatement().getResultSet();
        String password = retrievedPassword.getString(1);
        String password_entered = loginPassword.getText();
}