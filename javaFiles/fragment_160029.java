public class PgConnect {
    public static Connection connect() throws SQLException {
    try {
        Connection res = DriverManager.getConnection("jdbc:postgresql://pgserver:5432/db", "test","test123");
        if (res != null) {
            System.out.println("Connection working");
        } else {
            System.out.println("Failed to make connection!");
        }
        return res;
    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        throw e;
    }
}