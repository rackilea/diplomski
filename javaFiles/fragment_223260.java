public static void main(String[] args) throws ClassNotFoundException,
        InstantiationException, IllegalAccessException, SQLException {
    System.out.println("Java version: "
            + System.getProperty("java.version"));
    Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver")
            .newInstance();
    System.out.println("JDBC driver: " + driver.getMajorVersion() + "."
            + driver.getMinorVersion());
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/DBNAME", "user", "pass");
    System.out.println("Connection: " + connection.getClass().getName());
}