public class Database {

    private static DataSource dataSource;

    static {
        try {
            dataSource = new InitialContext().lookup("jndifordbconc");
        }
        catch (NamingException e) { 
            throw new ExceptionInInitializerError("'jndifordbconc' not found in JNDI", e);
        }
    }

    public static Connection getConnection() {
        return dataSource.getConnection();
    }

}