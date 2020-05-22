private void dropdownActionPerformed(java.awt.event.ActionEvent evt) {                                             
    if (dropdown.getSelectedIndex() == 1) {
        NewFrame newFrame = new NewFrame(this); //the keyword this did the trick
        newFrame.setVisible(true);
    }
}