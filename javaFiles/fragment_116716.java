MongoClient mongoClient = new MongoClient();
 MongoDatabase db = mongoClient.getDatabase("db");
 MongoCollection<Document> collection = db.getCollection("collection");

 BsonField id = Accumulators.first("ID", "$ID");
 BsonField name = Accumulators.first("NAME", "NAME");
 BsonField amount = Accumulators.sum("amount", "$amount");

 Bson group = Aggregates.group("$NAME", id, name, amount);
 Bson sort = Aggregates.sort(Sorts.descending("NAME"));

 List<Document> results = collection.aggregate(Arrays.asList(group, sort)).into(new ArrayList<>());