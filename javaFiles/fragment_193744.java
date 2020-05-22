MongoClient client = new MongoClient(new ServerAddress("192.168.2.4", 27017));

    MongoDatabase db = client.getDatabase("test");

    MongoCollection<Document> collection = db.getCollection("sample");

    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
            new BasicDBObject("$sort", new BasicDBObject("score", -1)),
            new BasicDBObject("$limit", 1)
    )).allowDiskUse(true);

    MongoCursor<Document> cursor = result.iterator();

    while (cursor.hasNext()) {
        Document doc = cursor.next();
        System.out.println(doc);
    }