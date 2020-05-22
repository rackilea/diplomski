ConfigurationDBRef dbConfig = new ConfigurationDBRef();
dbConfig.setDriverManagerConnection("org.postgresql.Driver",
                                    "jdbc:postgresql://localhost:5432/database_name", 
                                    "user", 
                                    "password");

Configuration engineConfig = new Configuration();
engineConfig.addDatabaseReference("database_alias", dbConfig);

esperEngine = EPServiceProviderManager.getDefaultProvider(engineConfig);