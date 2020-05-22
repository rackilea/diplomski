try {
    Class.forName(JDBC_DRIVER);
    dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
} catch (SQLException e) {
    throw new MyException(e);
}