import static com.mongodb.client.model.Aggregates.unwind;

Bson unwind = unwind("$sizes");

        List<Bson> pipeline = asList(unwind);

        MongoClient c = new MongoClient();
        MongoCollection<Document> collection = c.getDatabase("test")
                .getCollection("unwind");

        List<Document> results = collection.aggregate(pipeline).into(
                new ArrayList<Document>());

        for (Document cur : results) {
            System.out.println(cur.toJson());
        }
    }