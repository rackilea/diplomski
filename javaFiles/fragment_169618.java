public static Configuration buildConfiguration(String serverName, String databaseName) {
        return createConfiguration()
                .setProperty("connection.url", "jdbc:postgresql://" + serverName + ":5432/" + databaseName)
    }

private static Configuration createConfiguration() {
        Configuration configuration = new Configuration().configure(HIBERNATE_CFG_XML_FILE);
        return configuration;
    }

configuration.buildSessionFactory();