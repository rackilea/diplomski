MongoClient client = new MongoClient("10.0.2.113" , 27017);
MongoDatabase db = client.getDatabase("maindb");
MongoCollection collection = db.getCollection("mainCollection")

BasicDBObject document = new BasicDBObject();

// Delete All documents from collection Using blank BasicDBObject
collection.deleteMany(document);

// Delete All documents from collection using DBCursor
DBCursor cursor = collection.find();
while (cursor.hasNext()) {
    collection.remove(cursor.next());
}