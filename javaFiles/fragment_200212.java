import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class StackoverflowTest {

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    private final DatastoreService _ds = DatastoreServiceFactory.getDatastoreService();

    /**
     * http://stackoverflow.com/questions/28031142/cannot-delete-entity-by-long-id
     */
    @Test(expected = EntityNotFoundException.class)
    public void test28031142() throws EntityNotFoundException {
        Entity e = new Entity(KeyFactory.createKey("Post", 1L));
        Key key = _ds.put(e); // _ds is native DatastoreService
        _ds.delete(KeyFactory.createKey("Post", 1L));
        _ds.get(KeyFactory.createKey("Post", 1L));
    }
}