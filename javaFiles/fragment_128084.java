MongoClient client = new MongoClient("localhost",27017);
MongoDatabase db = client.getDatabase("test");
MongoCollection<Document> collection = db.getCollection("RSS");
FindIterable<Document>  it = collection.find().limit(6).sort(new Document().append("$natural", -1));
MongoCursor<Document> cursor = it.iterator();
while(cursor.hasNext()){
    Document doc = cursor.next();
    System.out.println(doc.toJson());
}