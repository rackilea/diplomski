public boolean createSchema(final String tenantId) throws SQLException {
    boolean result = false;

    if(_configuration != null && _dataSource != null) {

        // Get a local configuration to configure
        final Configuration tenantConfig = _configuration;

        // Set the properties for this configuration
        Properties props = new Properties();
        props.put(Environment.DEFAULT_SCHEMA, tenantId);
        tenantConfig.addProperties(props);

        // Get connection
        Connection connection = DriverManager.getConnection(_dataSource.getUrl(), 
                _dataSource.getUsername(), _dataSource.getPassword());

        // Create the schema
        connection.createStatement().execute("CREATE SCHEMA " + tenantId + "");

        // Run the schema update from configuration
        SchemaUpdate schemaUpdate = new SchemaUpdate(tenantConfig);
        schemaUpdate.execute(true, true);

        // Set the schema
        connection.createStatement().execute("SET SCHEMA " + tenantId + "");

        // Set the result
        result = true;

    } else if(_configuration == null) {
        if(_LOGGER.isWarnEnabled()) {
            _LOGGER.warn("No configuration was specified for " + getClass().getSimpleName());
        }
    } else if(_dataSource == null) {
        if(_LOGGER.isWarnEnabled()) {
            _LOGGER.warn("No dataSource was specified for " + getClass().getSimpleName());
        }
    }

    return result;
}