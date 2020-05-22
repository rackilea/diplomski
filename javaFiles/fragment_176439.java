private void jButton_NextActionPerformed(java.awt.event.ActionEvent evt) {                                             
    new StudentRegistrationForm_3().setVisible(true);
    // How is StudentRegistrationForm_3 suppose to reference the User object??
    User user = new User(TexUsername.getText(),Password.getPassword());
    this.dispose();
}