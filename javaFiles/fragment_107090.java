// our you can inject this using Spring   
Properties properties = new Properties();
properties.load(CurrentClass.class.getClassLoader().getResourceAsStream("hazelcast.properties"));

final Config config = new XmlConfigBuilder("hazelcast-with-properties.xml")
        .setProperties(properties) // this is how you can set the properties 
        .build();

final HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);