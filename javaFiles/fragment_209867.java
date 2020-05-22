public class MyConnectionProvider implements ConnectionProvider {

    // Configure spring to inject your data source here
    @Autowire
    DataSource ds;

    @Override
    public Connection acquire() {
        try {
            Connection c = ds.getConnection();
            // Do your stuff here
            return c;
        }
        catch (SQLException e) {
            throw new DataAccessException("Something failed", e);
        }
    }

    @Override
    public void release(Connection c) {
        try {
            // Do your stuff here
            c.close();
        }
        catch (SQLException e) {
            throw new DataAccessException("Something failed", e);
        }
    }
}