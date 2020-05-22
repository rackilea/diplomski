@Test
public void canRead() {
    MongoClient mongoClient = new MongoClientFactory().create();

    MongoCollection<Document> collection = mongoClient.getDatabase("stackoverflow").getCollection("sample");

    // this test assumes that the two documents you showed in your question have already been written to the collection e.g.
    // collection.insertOne(Document.parse("{\"employee_id\": \"1\", \"details\": {\"name\":\"A\",\"age\":\"18\"}}"));
    // collection.insertOne(Document.parse("{\"employee_id\": \"2\", \"details\": {\"name\":\"B\",\"age\":\"18\"}}"));

    Bson filter = Filters.eq("employee_id", "1");
    Assert.assertEquals(1, collection.count(filter));

    Document document = collection.find(filter).first();
    Assert.assertEquals("1", document.get("employee_id"));
    Document details = (Document) document.get("details");
    Assert.assertEquals("A", details.get("name"));
    // age is a string?!
    Assert.assertEquals("18", details.get("age"));
}