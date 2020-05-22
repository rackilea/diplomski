import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.types.ObjectId;

@Path("/users")
public class MongoResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMongoObject(@PathParam("id") String id) throws Exception {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        DB db = mongoClient.getDB("mfj");
        DBCollection collection = db.getCollection("user");
        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
        DBCursor cursor = collection.find(query);
        DBObject object = cursor.next();
        if (object == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(object.toString()).build();
    }
}