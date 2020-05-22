public Mongo() {
    String serverName = ""; //Usually it's 'localhost'
    String serverPort = ""; //Usually it's '8080'
    try {
        mongoClient = new MongoClient(serverName, serverPort);
        db = mongoClient.getDatabase("IFHKServer");
    } catch (MongoClientException e) {
        System.err.println("Error connecting to MongoDB Client.");
        Logger.getLogger(Mongo.class.getName()).log(Level.SEVERE, null, e);        }
}