static void fetch(int userid) throws SQLException
{
    PreparedStatement ps = null;
    ResultSet rs = null;

    String query = "SELECT * FROM Persons where pid = ?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1,userid);
    rs = ps.executeQuery(); //instantiate rs with executed query

    while(rs.next()) {
        password = rs.getString("password");
        BAL = rs.getInt("balance");
    }   
    if(upassword.equals(password)) {
        System.out.println("you are now logged in");
    } else {
        System.out.println("incorrect password");
    }
    rs.close();
    ps.close();    
}