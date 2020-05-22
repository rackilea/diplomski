Connection con = DriverManager.getConnection("url","username","password");
String sql = "select * from MyTable where username=? and password=?";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, "yourUsername");
ps.setString(2, "yourPassword");
ResultSet rs = ps.executeQuery();
if(rs.next()) {
    System.out.println("login successful");
    //code to redirect to login page
}