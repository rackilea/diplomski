PreparedStatement ps2;
ResultSet rs2;

String username = jTextField_username.getText();
String userpassword = jTextField_userpassword.getText();

String sql = "SELECT distinct kalanizin from users where username =?";
String[] resultsetarray = null;

try {
   ps2 = MyConnection.getConnection().prepareStatement(sql);
   ps2.setString(1, username);

   rs2 = ps2.executeQuery();
   if(rs2.next()) { // moving to the first row
       String result = rs2.getString(1); // i want this String to hold the first result
   } else {
       // throw Exception ?
   }
} catch (SQLException e) {
    e.printStackTrace();
}