public static void save(MongoCollection<Document> collection, Document document) {
    Object id = document.get("_id");
    if (id == null) {
        collection.insertOne(document);
    } else {
        collection.replaceOne(eq("_id", id), document, new UpdateOptions().upsert(true));
    }
}