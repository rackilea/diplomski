public final void closeMongoDBConnection() {
    try {
        mongoClient.close();
    } catch (Exception e) {
        System.err.println("Error in terminating connection");
        Logger.getLogger(Mongo.class.getName()).log(Level.SEVERE, null, e);
    }
}