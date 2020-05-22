MongoClient mongoClient = new MongoClient();
DB database = mongoClient.getDB("db");

DBCollection collection = database.getCollection("collection");
BasicDBObject projection = new BasicDBObject(new BasicDBObject("statusLog",new BasicDBObject("$elemMatch", new BasicDBObject("status", "Submitted"))));
collection.find(new BasicDBObject(), projection);