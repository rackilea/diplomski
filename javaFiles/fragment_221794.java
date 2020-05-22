MongoClient client = new MongoClient("localhost");
        MongoDatabase db = client.getDatabase("Test"); 
        MongoCollection<Document> collection = db.getCollection("solution");
        List<Document> results = collection.aggregate(Arrays.asList(
              new Document("$redact", new Document("$cond",
                      Arrays.asList(new Document("$eq",
                              Arrays.asList(new Document("$ifNull", Arrays.asList("$B", "aaaa")), "aaaa")), 
                      "$$DESCEND", "$$PRUNE")))

        )).into(new ArrayList<Document>());

        for(Document docs: results){
          System.out.println(docs.toJson());
        }