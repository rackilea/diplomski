MongoClient client = new MongoClient("localhost",27017);
        MongoDatabase db = client.getDatabase("TestDB");
        MongoCollection<Document> collection = db.getCollection("test");
        Document query = new Document();
        query.append("_id","test");
        Document setData = new Document();
        setData.append("status", 1).append("instagram.likes", 125);
        Document update = new Document();
        update.append("$set", setData);
        //To update single Document  
        collection.updateOne(query, update);