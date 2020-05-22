import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

// Authentication is automatic inside Google Compute Engine
// and Google App Engine.
Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
KeyFactory keyFactory = datastore.newKeyFactory().setKind(KIND);
Key key = keyFactory.newKey(keyName);
Entity entity = datastore.get(key);