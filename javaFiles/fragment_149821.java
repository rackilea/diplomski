ComboPooledDataSource dataSource = null;
    Connection connection = null;
    try {
        dataSource = dataSourceFactory.getDataSource(dbType, dbProps);
        // Get a connection from the datasource
        connection = dataSource.getConnection();
    } finally {
        if (connection!=null){
            connection.close();
        }
        if (dataSource != null) {
            try {
                log.debug("validate() : Closing SQL connection pool");
                DataSources.destroy(dataSource);
                dataSource = null;
                log.debug("validate() : SQL connection pool is closed");
            } catch (Exception e) {
                log.error("validate() : Error closing data source", e);
            }
        }       
    }