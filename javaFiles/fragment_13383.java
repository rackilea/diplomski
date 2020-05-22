private void confirmActionPerformed(java.awt.event.ActionEvent evt) {
  boolean valid = true;

  if (lname1.getText().equals("")) {
    lname_ver1.setText("Field is empty!");
    valid = false;
  }
  if (mname1.getText().equals("")) {
    mname_ver1.setText("Field is empty!");
    valid = false;
  }
  ...
  if (valid) {
    JOptionPane.showMessageDialog(null, "SUCCESS", "INFO    ", JOptionPane.INFORMATION_MESSAGE);
    dispose();
    Schedule sched = new Schedule();
    sched.setLocationRelativeTo(null);
    sched.setResizable(false);
    sched.setVisible(true);
  }
}