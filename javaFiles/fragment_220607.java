MongoClient client = new MongoClient();
        MongoDatabase mongoDatabase = client.getDatabase("test");
        MongoCollection<Document> mongoCollection = mongoDatabase
                .getCollection("unwind");

        List<Document> pipeline;

        pipeline = Arrays.asList(Document.parse("{$unwind:\"$sizes\"}"));

        List<Document> results = mongoCollection.aggregate(pipeline).into(
                new ArrayList<Document>());

        for (Document cur : results) {
            System.out.println(cur.toJson());
        }