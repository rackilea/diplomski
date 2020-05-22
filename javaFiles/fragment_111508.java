BaseConfiguration baseConfiguration = new BaseConfiguration();
baseConfiguration.setProperty("storage.backend", "cassandra");
baseConfiguration.setProperty("storage.hostname", "192.168.3.82");

//First Graph
baseConfiguration.setProperty("storage.cassandra.keyspace", "keyspace1");
TitanGraph titanGraph1 = TitanFactory.open(baseConfiguration);

//Second Graph
baseConfiguration.setProperty("storage.cassandra.keyspace", "keyspace2");
TitanGraph titanGraph2 = TitanFactory.open(baseConfiguration);