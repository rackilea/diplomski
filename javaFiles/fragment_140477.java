MongoClient mongoClient = ...;

MongoCollection<Document> collection = mongoClient.getDatabase("...").getCollection("...");

AggregateIterable<Document> documents = collection.aggregate(Arrays.asList(

    // Java equivalent of the $match stage
    Aggregates.match(Filters.regex("name", "John")),

    // Java equivalent of the $group stage
    Aggregates.group("$name", Accumulators.first("category", "$category"))

));

for (Document document : documents) {
    System.out.println(document.toJson());
}