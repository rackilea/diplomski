public static DBInterface Conn() throws SQLException, ClassNotFoundException {
    String  url = "jdbc:mysql://localhost:3306/cmwebapp";
    String user = "user";
    String pw = "password";
    DBInterface dbInterface = new DBInterface();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        dbInterface.conn = (Connection) DriverManager.getConnection(url, user, pw);
    } catch (SQLException e) {
        System.out.println("MySQL Connection failed.");
        e.printStackTrace();
    }
    return dbInterface;
}