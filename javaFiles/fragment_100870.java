try (Connection connection = DriverManager.getConnection(url, userid, pwd);
     PreparedStatement pstmt = connection.prepareStatement(
         "select * from emp where Name = ? and Designation = ? and Pay = ? and City = ?")) {
   pstmt.setString(1, search);
   pstmt.setString(2, search1);
   pstmt.setDouble(3, search2);
   pstmt.setString(4, search3);
   try (ResultSet rs = pstmt.executeQuery()) {
       if (rs.next() {
           String nm = rs.getString("Name");
           String desg = rs.getString("Designation");
           double pay = rs.getDouble("Pay");
           String city = rs.getString("City");
           jTextField1.setText(nm);
           jTextField2.setText(desg);
           jTextField3.setText(String.valueOf(pay));
           jTextField4.setText(city);
       } else {
           // handle not found case
       }
   } 
}