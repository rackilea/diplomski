import static com.mongodb.client.model.Projections.elemMatch;

 public static String getValue3(){
      MongoClient mongoClient = new MongoClient("localhost", 27017);
      MongoDatabase db = mongoClient.getDatabase("test2");
      MongoCollection<Document> collection = db.getCollection("test1");
      if(collection == null)
        return "";
      Document doc = collection.find(eq("value1", "aaa")).projection(elemMatch("arrayvalue", eq("value2", "aaaa"))).first();
      if(doc != null) {
        List<Document> arrayValue = doc.get("arrayvalue", List.class);
        return arrayValue.get(0).get("value3").toString();
      }
      return "";
 }