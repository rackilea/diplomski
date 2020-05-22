import java.util.LinkedHashMap;
import java.util.Map;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongodbTest {
    public static void main(String[] args) throws Exception {
        String tableName = "UniqueAddressTest";
        DB mdb = new MongoClient("localhost:27017").getDB(tableName);
        Jongo jdb = new Jongo(mdb);
        MongoCollection users = jdb.getCollection(tableName);
        users.drop();
        users.ensureIndex("{address:1}", "{unique:true}");
        Map<String, Object> user1 = new LinkedHashMap<String, Object>();
        Map<String, Object> address1 = new LinkedHashMap<String, Object>();
        address1.put("floor", 0);
        address1.put("block", "5");
        address1.put("city", "Mumbai");
        address1.put("state", "ABC");
        address1.put("pincode", 0);
        address1.put("latitude", "77.6876");
        address1.put("longitude", "13.57558");
        address1.put("hash", "1axuhWcqKB");
        user1.put("address", address1);
        users.insert(user1);
        users.insert(user1); // Here is where duplicate key exception happens
    }
}