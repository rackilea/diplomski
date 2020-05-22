import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class GetDataFromTableWebsrvsDtls {
    public static void main(String[] args) {

        MongoClient client = new MongoClient();

        MongoDatabase database = client.getDatabase("localhost");

        MongoCollection<Document> collection = database.getCollection("TableWebsrvsDtls");

        FindIterable<Document> collectionData = collection
                .find(Filters.and(Filters.eq("col1", "1000"), Filters.eq("col4", "EMEA")))
                .projection(Projections.include("col1", "col2"));

        for (Document doc : collectionData) {
            System.out.println(doc.toJson());
        }

        client.close();

    }

}