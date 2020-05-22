public static void main(String [] args) throws Exception  {
    final String URI = "mongodb://localhost:27017";            
    final String DB = "StackOverflowQuestion";
    final String COLLECTION = "eqDoesntExcist";

    MongoClientURI connection = new MongoClientURI(URI);
    MongoClient mongo = new MongoClient(connection);
    MongoDatabase database = mongo.getDatabase(DB);
    MongoCollection<Document> collection = database.getCollection(COLLECTION);

    Set<String> namesOfTroysKids = new HashSet<>();
    namesOfTroysKids.add("Paul");
    namesOfTroysKids.add("Jane");
    namesOfTroysKids.add("Mark");
    namesOfTroysKids.add("Ivona");

    Document doc = new Document("name", "Troy").append("height", 185).append("kids", namesOfTroysKids);
    collection.insertOne(doc);

    // read something from mongo
    FindIterable<Document> findIt = collection.find(Filters.eq("name", "Troy")).projection(Projections.include("kids"));
    Document d = findIt.first();

    System.out.println("doc: " + d.toJson());

    List<String> kidsList = (List<String>) d.get("kids", List.class);

    Set<String> kidsSet = new HashSet<>(kidsList);

    System.out.println("kids: " + kidsSet);
}