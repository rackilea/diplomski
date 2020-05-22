MongoClient mongoClient = ...;

MongoCollection<Document> collection = mongoClient.getDatabase("...")
    .getCollection("...");

collection.find(query)