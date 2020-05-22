MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017));
DB db = mongo.getDB("thedb");
DBCollection collection = db.getCollection("test");

BasicDBObject query = new BasicDBObject();
query.append("age", 25);

collection.remove(query);