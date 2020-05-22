import static com.mongodb.client.model.Filters.*;

MongoClient client = new MongoClient();
MongoDatabase database = client.getDatabase("mydb");
MongoCollection<Document> collection = database.getCollection("mycoll");
myDoc = collection.find(eq("_id", "test")).first();
System.out.println(myDoc.toJson());