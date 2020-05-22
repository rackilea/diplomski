import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

MongoClient mongoClient = new MongoClient(); 
MongoDatabase database = mongoClient.getDatabase("db"); // Get DB

MongoCollection<Document> collection = database.getCollection("collection"); // Get Collection
Bson projection = Projections.fields( excludeId(), include("createdDate"), elemMatch("statusLog", eq("status", "Submitted"))); // Add Projections
FindIterable<Document> iterable = collection.find().projection(projection);