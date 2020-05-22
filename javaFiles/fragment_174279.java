if (foo) {
    Connection con = DriverManager.getConnection(host, uName, uPass);
}
String sql = "INSERT INTO Users (UserId, fName, lastName, userName, password) " +
             "VALUES (?, ?, ?, ?, ?)";

// Compilation error     vvv
PreparedStatement stmt = con.prepareStatement(sql, 
                                              Statement.RETURN_GENERATED_KEYS);