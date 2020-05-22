public class DbConnectionRessource extends ExternalRessource {

    private Connection connection;

    @Override
    protected void before() throws SQLException {
        connection = DbUtil.openConnection();
    }

    @Override
    protected void after() {
        DbUtil.closeConnection(connection);
    }

    public Connection getConnection() {
        return connection;
    }
}