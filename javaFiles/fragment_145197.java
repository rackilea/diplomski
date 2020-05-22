@Autowired
private ApplicationContext appContext;

public MongoDbFactory mongoDbFactory() throws UnknownHostException {
    return new SimpleMongoDbFactory(new MongoClient("localhost"), "apollo-mongodb");
}

@Bean
MongoTemplate mongoTemplate() throws UnknownHostException {
    final MongoDbFactory factory = mongoDbFactory();

    final MongoMappingContext mongoMappingContext = new MongoMappingContext();
    mongoMappingContext.setApplicationContext(appContext);

    // Learned from web, prevents Spring from including the _class attribute
    final MappingMongoConverter converter = new MappingMongoConverter(factory, mongoMappingContext);
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    return new MongoTemplate(factory, converter);
}