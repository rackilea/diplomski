public class MultitenantConnectionProvider implements MultiTenantConnectionProvider, ServiceRegistryAwareService {

    private static final long serialVersionUID = 4368575201221677384L;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(MultitenantConnectionProvider.class);

    private DataSource lazyDatasource = null;

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    /**
     * The DataSource/ConnectionPool we are using is the one configured by the environment
     * Which by default, in our case, is configured at client-persistence-cfg.xml
     * (named Client Data Source)
     */
    @Override
    public void injectServices(ServiceRegistryImplementor serviceRegistry) {
        Map lSettings = serviceRegistry.getService(ConfigurationService.class).getSettings();
        lazyDatasource = (DataSource) lSettings.get(Environment.DATASOURCE);
    }

    @Override
    public boolean isUnwrappableAs(Class clazz) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        return null;
    }

    /**
     * Retrieve any connection from the Connection Pool
     */
    @Override
    public Connection getAnyConnection() throws SQLException {
        return lazyDatasource.getConnection();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        final Connection connection = getAnyConnection();
        try {
            connection.createStatement().execute("SET SCHEMA '" + tenantIdentifier + "'");
        }
        catch (SQLException e) {
            throw new HibernateException("Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]", e);
        }
        return connection;
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        try {
            connection.createStatement().execute("SET SCHEMA 'public'");
        }
        catch (SQLException e) {
            throw new HibernateException("Could not alter JDBC connection to specified schema [public]", e);
        }
        connection.close();
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        releaseAnyConnection(connection);
    }
}