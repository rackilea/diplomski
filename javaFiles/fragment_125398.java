/**
 * DB connection Factory
 * 
 * @return a ready to use MongoDbFactory
 */
@Bean
public MongoDbFactory mongoDbFactory() throws Exception {

    // Set credentials      
    MongoCredential credential = MongoCredential.createCredential(mongoUser, databaseName, mongoPass.toCharArray());
    ServerAddress serverAddress = new ServerAddress(mongoHost, mongoPort);

    // Mongo Client
    MongoClient mongoClient = new MongoClient(serverAddress,Arrays.asList(credential)); 

    // Mongo DB Factory
    SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
            mongoClient, databaseName);

    return simpleMongoDbFactory;
}

/**
 * Template ready to use to operate on the database
 * 
 * @return Mongo Template ready to use
 */
@Bean
public MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
}