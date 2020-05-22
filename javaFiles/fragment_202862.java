import static com.mongodb.client.model.Filters.eq;

    MongoClient mongoClient = new MongoClient(new ServerAddress(
            "localhost", 27017));
    MongoDatabase db = mongoClient.getDatabase("testDB");
    MongoCollection<Document> collection = db.getCollection("coll");
    Document doc = collection.find(eq("_id", "11")).projection(Projections.include("userFriends.user_id")).first();

    List list = (List) doc.get("userFriends");
    String[] arr = new String[list.size()];

    for (int i = 0; i < list.size(); i++) {
        Document obj = (Document) list.get(i);
        arr[i] = (String) obj.get("user_id");
    }