MongoCollection<Document> collection = db.getCollection("sample");

    List<WriteModel<Document>> updates = Arrays.<WriteModel<Document>>asList(
        new UpdateOneModel<Document>(
                new Document(),                   // find part
                new Document("$set",1),           // update part
                new UpdateOptions().upsert(true)  // options like upsert
        )
    );

    BulkWriteResult bulkWriteResult = collection.bulkWrite(updates);