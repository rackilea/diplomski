DBObject document1 = new BasicDBObject();
document1.put("name", "Kiran");
document1.put("age", 20);

DBObject document2 = new BasicDBObject();
document2.put("name", "John");

List<DBObject> documents = new ArrayList<>();
documents.add(document1);
documents.add(document2);
collection.insert(documents);