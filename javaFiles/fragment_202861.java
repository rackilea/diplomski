MongoClient mongoClient = new MongoClient(new ServerAddress(
            "localhost", 27017));
    MongoClient mongo = new MongoClient("localhost", 27017);
    DB db = (DB) mongo.getDB("testDB");
    DBCollection collection = db.getCollection("coll");
    BasicDBObject fields = new BasicDBObject().append(
            "userFriends.user_id", 1).append("_id", 0);
    BasicDBObject query = new BasicDBObject().append("_id", "11");
    DBObject dbObj = collection.findOne(query, fields);
    BasicDBList list = (BasicDBList) dbObj.get("userFriends");

    String[] arr = new String[list.size()];

    for (int i = 0; i < list.size(); i++) {

        DBObject obj = (DBObject) list.get(i);
        arr[i] = (String) obj.get("user_id");
    }