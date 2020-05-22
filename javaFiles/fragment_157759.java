fun provideDbConfig(): DbConfig {
        val settings = ServerSettings(System.getenv("app_environment"))
        settings.printSettings()

        return DbConfig(
                dbHost = settings.getString("dbHost"),
                dbUsername = settings.getString("dbUsername"),
                dbPassword = settings.getString("dbPassword"),
                dbName = settings.getString("dbName"),
                dbPort = settings.getInt("dbPort")
        )
    }