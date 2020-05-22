static {
    try{
        Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
        throw new ExceptionInInitializerError("Driver " + DRIVER + " missing in classpath", e);
    }
}

public static Connection createConnection() throws SQLException {
    return DriverManager.getConnection(DBURL, "root", "toor");
}