public void doPost(...){
    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    DB database = mongoClient.getDB("db");
    DBCollection collection = database.getCollection("coll");
    DBObject getDocs = new BasicDBObject();
    DBCursor cursor = collection.find(getDocs);
    while(cursor.hasNext()){
        returnString += String.format("%s",cursor.next());
    }
    response.getWriter().write(returnString);
}