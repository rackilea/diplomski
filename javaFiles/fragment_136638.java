public void buildMongoClient() {
    MongoClientOptions.Builder clientOptions = new MongoClientOptions.Builder();
    clientOptions.minConnectionsPerHost();//min
    clientOptions.connectionsPerHost();//max
    mongoClient = new MongoClient(new ServerAddress(dbHostName, dbPort), clientOptions.build);
    mongoDatabase = mongoClient.getDatabase(DATABASE);
 }