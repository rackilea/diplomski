try {
    Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
     e.printStackTrace();
}

try {
    Connection con = DriverManager.getConnection(s, username, password);
}
catch (SQLException e) {
    e.printStackTrace();
}