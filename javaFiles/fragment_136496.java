private String uri;

public void setUri(String uri) {
    this.uri = uri;
}

public MongoDbFactory mongoDbFactory() throws Exception {
    return new SimpleMongoDbFactory(new MongoClientURI(uri));
}

abstract public MongoTemplate getMongoTemplate() throws Exception;