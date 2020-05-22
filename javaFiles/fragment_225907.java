import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.DatastoreImpl;
import org.mongodb.morphia.Morphia;
import java.net.UnknownHostException;

.....
    private Datastore createDataStore() throws UnknownHostException {
        MongoClient client = new MongoClient("localhost", 27017);
        // create morphia and map classes
        Morphia morphia = new Morphia();
        morphia.map(FooBar.class);
        return new DatastoreImpl(morphia, client, "testmongo");
    }

......

    //with the Datastore from above you can save any mapped class to mongo
    Datastore datastore;
    final FooBar fb = new FooBar("hello", "world");
    datastore.save(fb);