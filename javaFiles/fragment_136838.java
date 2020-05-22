@Test
public void canBulkWriteAndIdentifySpecificFailedDocuments() throws IOException {
    MongoClient mongoClient = new MongoClientFactory().create();

    MongoCollection<Document> collection = mongoClient.getDatabase("stackoverflow").getCollection("bulkwrite");

    // fresh start for this test case
    collection.drop();

    Document knownDocument = new Document().append("name", new BsonString("beep"));
    collection.insertOne(knownDocument);

    collection.createIndex(new BasicDBObject("name", 1), new IndexOptions().unique(true));

    int createDuplicateOnIndex = 2;
    List<Document> docs = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
        if (i == createDuplicateOnIndex) {
            // deliberately trigger a duplicate key exception
            docs.add(knownDocument);
        } else {
            docs.add(new Document().append("name", new BsonString("beep" + i)));
        }
    }

    try {
        collection.insertMany(docs, new InsertManyOptions().ordered(false));
    } catch (MongoBulkWriteException ex) {
        assertThat(ex.getWriteResult().getInsertedCount(), is(4));
        assertThat(ex.getMessage(), containsString("duplicate key error"));
        assertThat(ex.getWriteErrors().size(), is(1));
        assertThat(ex.getWriteErrors().get(0).getIndex(), is(createDuplicateOnIndex));
        assertThat(ex.getWriteErrors().get(0).getCode(), is(11000));
        assertThat(ex.getWriteErrors().get(0).getMessage(), startsWith("E11000 duplicate key error"));
    }
}