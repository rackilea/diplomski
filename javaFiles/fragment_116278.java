public static void main(final String[] args) throws UnknownHostException {
final MongoClient mongoClient = new MongoClient("localhost", 27017);
final DB database = mongoClient.getDB("dbTest2");
final DBCollection collection = database.getCollection("colTest2");
final long count = collection.count();
final DBObject dbObject = new BasicDBObject();
dbObject.put("_id", "test");
final DBCursor curr = collection.find(dbObject);
while (curr.hasNext()) {
    final DBObject dbo = curr.next();
    final BSONObject object = (BSONObject) dbo.get("markers");
    System.out.println(object.get("firstmarker"));
}
}