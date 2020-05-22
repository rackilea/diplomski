import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

Query q = new Query (Task.class.getName());
PreparedQuery pq = DatastoreServiceFactory.getDatastoreService ().prepare (q);
for (Entity entity : pq.asIterable ())
{
    String orig = entity.getProperty ("userId").toString ();
    entity.removeProperty ("userId");
    entity.setProperty ("userId", Long.parseLong (orig));
}