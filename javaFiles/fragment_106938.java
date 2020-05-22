private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
    myFrame = new JFrame("Hello World");
    modal = new JDialog(myFrame, "This is a modal!", true);
    modal.setVisible(true);
    modal.setLocationRelativeTo(null); //Center the modal
}