MongoClientURI uri  = new MongoClientURI(MONGO_URL);
MongoClient mongoClient = new MongoClient(uri);
DBCollection db = mongoClient.getDB(uri.getDabase()).getCollection(COLLECTION_NAME);

BasicDBObject query = new BasicDBObject("accountName", accountName);
BasicDBObject projection = new BasicDBObject("password", 1);
DBCursor cursor = db.find(query, projection);