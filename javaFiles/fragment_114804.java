private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
    String nickname = edtNickname.getText();
    String loginID = edtLoginID.getText();
    String password = String.valueOf(edtPassword.getPassword());
    String confirmPassword = String.valueOf(edtReenterPassword.getPassword());


    if (!password.equals(confirmPassword)) {
        lblErrorMessage.setText("Passwords do not match");
    }
    if (nickname.equals("") || loginID.equals("") || password.equals("")) {
        lblErrorMessage.setText("You must fill in  the text fields");
    }

    boolean addUser = true;
    for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getLoginID().equals(loginID)) {
            JOptionPane.showMessageDialog(null, "User exists in file");
            addUser = false;
            break;//no need to keep checking so break out of the for loop
         } else {
            JOptionPane.showMessageDialog(null, "User does not exist");
         }
    }

    if(addUser)
    {
        User user = new User(nickname, loginID, password);
        users.add(user);
        //now save the contents of the list to the file
        saveToFile();
    }
}