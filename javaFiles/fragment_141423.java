import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

DatastoreOptions options = DatastoreOptions.newBuilder()
  .setProjectId(PROJECT_ID)
  .setCredentials(GoogleCredentials.fromStream(
    new FileInputStream(PATH_TO_JSON_KEY))).build();
Datastore datastore = options.getService();
KeyFactory keyFactory = datastore.newKeyFactory().setKind(KIND);
Key key = keyFactory.newKey(keyName);
Entity entity = datastore.get(key);