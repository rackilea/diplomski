public class Database {

    private static OracleDataSource dataSource;

    public static void login(String userName, String password) {
         try {
            dataSource = new OracleDataSource();
            dataSource.setURL("myjdbcaddress");
            dataSource.setUser(userName);
            dataSource.setPassword(password);

            System.out.print("Static block executed...");
        } catch (SQLException e) {
            throw new IllegalStateException("Initial Database Connection not established. Sorry.", e);
        }
    }

    ...
}