import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        PrintWriter out  = null;
        MongoClient mongoClient = null;

        try {

            mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = db.getCollection("sample");

            out = new PrintWriter(
                    new BufferedWriter(new FileWriter("output.txt"))
            );

            // Clear collection and insert data
            collection.deleteMany(new Document());
            collection.insertMany(Arrays.asList(
                    new Document("a", 1),
                    new Document("a", 2),
                    new Document("a", 3)
            ));

            MongoCursor<Document> cursor = collection.find().iterator();

            while ( cursor.hasNext() ) {
                out.println(cursor.next().toJson());
                //System.out.println(cursor.next().toJson());
            }

            out.flush();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }
}