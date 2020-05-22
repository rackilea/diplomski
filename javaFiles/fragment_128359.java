@Test
public void aQuery() {
    MongoClient mongoClient = new MongoClientFactory().create();

    MongoCollection<Document> collection = mongoClient.getDatabase("stackoverflow").getCollection("ors");

    Pattern regex = Pattern.compile("^2017-07-25");
    Pattern regex2 = Pattern.compile("^ActFLA_A");
    Pattern regex3 = Pattern.compile("^10");

    Bson clause1 = Filters.regex("TranDate", regex);
    Bson clause2 = Filters.regex("TranCode", regex2);
    Bson clause3 = Filters.regex("Configuration", regex3);

    Bson query = Filters.and(clause1, clause2, clause3);

    Assert.assertEquals(3, collection.count(query));

    // let's have a look at the matched docs ...
    FindIterable<Document> documents = collection.find(query);
    for (Document document : documents) {
        logger.info(document.toJson());
    }
}