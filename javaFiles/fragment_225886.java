public class MongoStatusListener implements ServerListener {

    private boolean available = false;

    public boolean isAvailable() {
        return available;
    }

    @Override
    public void serverOpening(ServerOpeningEvent event) {}

    @Override
    public void serverClosed(ServerClosedEvent event) {}

    @Override
    public void serverDescriptionChanged(ServerDescriptionChangedEvent event) {

        if (event.getNewDescription().isOk()) {
            available = true;
        } else if (event.getNewDescription().getException() != null) {
            //System.out.println("exception: " + event.getNewDescription().getException().getMessage());
            available = false;
        }
    }
}

public MongoClient getMongoClient(String login, String password) {

    if (mongoClient != null) {
        return mongoClient;
    }
    MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
    MongoStatusListener mongoStatusListener = new MongoStatusListener();
    optionsBuilder.addServerListener(mongoStatusListener);

    this.mongoClient = new MongoClient(asList(new ServerAddress("localhost"), new ServerAddress("localhost:27017")),
        singletonList(MongoCredential.createCredential(
        login,
        "cookbook",
        password.toCharArray())
    ), optionsBuilder.build());

    this.mongoDatabase = mongoClient.getDatabase("cookbook");
    return mongoClient;
}

public boolean isAvailable() {
    return mongoStatusListener.isAvailable();
}