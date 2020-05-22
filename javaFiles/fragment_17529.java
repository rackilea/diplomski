Bson bson = Filters.eq("name", "Bob");

BsonDocument asBsonDocument = bson.toBsonDocument(BsonDocument.class, 
    MongoClient.getDefaultCodecRegistry());

System.out.println(asBsonDocument.toJson());