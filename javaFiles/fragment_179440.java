private void take_System_date_jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                                          

    DateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    jTextField1.setText(onlyDate.format(date));
    jLabel1.setText(jTextField1.getText());
}