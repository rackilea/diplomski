for(String collectionName : mongoOperation.getCollectionNames()){

    DBCollection collection = mongoOperation.getCollection(collectionName);

    DBObject query = new BasicDBObject();
    query.put("_id", new ObjectId(id));

    DBCursor cursor = dbCollection.find(query);

    if(cursor.hasNext()){
        //match
        //do something
        break;
    }

}