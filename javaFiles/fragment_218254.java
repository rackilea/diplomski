private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con;
    Statement stmt;
 try {

    Class.forName("sun.jdbc.odbc.JdbcOdbc");
} catch (ClassNotFoundException ex) {
    JOptionPane.showMessageDialog(null, ex);
 }
  //add this to remove all Items
     JcbSub.removeAllItems();
 if(jComboBox3.getSelectedItem() == 0) {
  try {


     con= DriverManager.getConnection("Jdbc:Odbc:food");
     stmt= con.createStatement();
     String sql="select i_name from food where category= '"+jComboBox3.getSelectedItem().toString()+"'";
     ResultSet RS= stmt.executeQuery(sql);
     JcbSub.setSelectedItem("");
     while(RS.next()){

        JcbSub.addItem(RS.getString("i_name"));


    }



} catch (SQLException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}

}else if(jComboBox3.getSelectedItem()  == 1) {
//etc... 
}
// or use Switch case    

}