import com.mongodb.Mongo;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DB;

public class MongoTest {

    public static void main(String[] args) throws Exception {

        // connect to the local database server
        Mongo m = new Mongo();

        DB db = m.getDB( "test" );

        DBCollection coll = db.getCollection("test");

        // delete all the data from the 'test' collection
        coll.drop();

        // make a document
        BasicDBObject doc = new BasicDBObject();

        doc.put("id", 7);
        doc.put("title", "test4");
        doc.put("modified", "2012-09-27");

        BasicDBObject status = new BasicDBObject();

        status.put("id", "1");
        status.put("name", "Expired");

        doc.put("status", status);

        // insert
        coll.insert(doc);

        BasicDBObject query = new BasicDBObject("status.name", "Expired");

        //  run the query and print the results out
        DBCursor cursor = coll.find(query);

        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

        m.close();
    }
}