HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        config.setJdbcUrl("jdbc:hsqldb:hsql://localhost/");
        config.addDataSourceProperty("user", "SA");
        config.addDataSourceProperty("password", "");

        HikariDataSource ds = new HikariDataSource(config);
        System.out.print("Data source created");
        Connection conn = ds.getConnection();