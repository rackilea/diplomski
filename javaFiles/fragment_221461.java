final HikariConfig config = new HikariConfig();
    config.setPoolName(environment.getProperty("datasourcewww.serverName"));
    config.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
    config.setUsername(userName);
    config.setPassword(password);
    config.addDataSourceProperty("serverName", serverName);

    config.addDataSourceProperty("databaseName", databaseName);
    config.setConnectionTimeout(10000);
    config.setMinimumIdle(10);
    config.setMaximumPoolSize(200);
    config.setIdleTimeout(1800000);

    LOG.info("HikariCP DataSource initialized.");
    return new HikariDataSource(config);