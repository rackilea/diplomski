private void jButton_NextActionPerformed(java.awt.event.ActionEvent evt) {                                             
    User user = new User(TexUsername.getText(),Password.getPassword());
    StudentRegistrationForm_3 form = new StudentRegistrationForm_3(user);
    form.setUser(user);
    this.dispose();
}