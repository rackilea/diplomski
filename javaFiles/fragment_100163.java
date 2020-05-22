private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
  conn=MySqlConnect.ConnectDB();
  System.out.println("id"+textid.getText()+" username"+textusernameR.getText()+" password"+textpasswordR.getText()); // print the data (please take this to a DTO class would be better)
  String sql ="insert into login(column1,column2,column3)values(?,?,?)";// please mention the coulmn name
  try {
    pst=conn.prepareStatement(sql);
    pst.setString(1,textid.getText());// if id is an integer column you will get error here
    pst.setString(2,textusernameR.getText());
    pst.setString(3,textpasswordR.getText());
    boolean flag = pst.execute();//this will return true or false
    //pst.executeUpdate() it will return effected row number i prefer this method always for DDL commands
    if(flag )JOptionPane.showMessageDialog(null,"Account created sucessfully");
    else JOptionPane.showMessageDialog(null,"Account creation failed");

   } catch (SQLException e) {
       e.printStackTrace(); // print the stack trace
    }

}