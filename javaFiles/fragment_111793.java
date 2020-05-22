public class ConnectionProvider {
    public static Connection getConnection() throws SQLException {
      Connection connection = null;
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudbase"
                                                                        ,user,passwd);
      return connection;
    }

   public void authenticate(Connection connection,String usrname,String pwd) 
       throws SQLException {
    String query = "select firstName from users where email=? and password = ?";
    try {
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setString(1, usrname);
        stm.setString(2, pwd);
        ResultSet result = stm.executeQuery();
        if (resultSet.next()) {
            do {
               System.out.println("Welcome, "+resultSet.getString("firstName"));
            } while(resultSet.next());
        }
       else{
           System.out.println("Username or id doesnot exist");
     }
    } catch (SQLException e) {
        System.out.println("Error :" + e.getMessage());   
    }
    finally{
       connection.close();
}

}