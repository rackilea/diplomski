MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase database = mongoClient.getDatabase("Test");

        MongoCollection<Document> collection = database.getCollection("collection");
        ArrayList<Document> doc = new ArrayList<Document>();
        doc.add(new Document().append("$unwind","$sites"));
        doc.add(new Document().append("$project",new Document().append("sitename","$sites.sitename")));
        List<Document> results =collection.aggregate(doc).into(new ArrayList<Document>());
        for(Document res: results){
            System.out.println(res.toJson());
        }