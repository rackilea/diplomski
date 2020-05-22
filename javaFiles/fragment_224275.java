import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

public class TestRoutes {
    @Before
    public void setUp() throws Exception {
        Routes newRoutes = new Routes();
        newRoutes.establishRoutes();

        awaitInitialization();

    }

    @After
    public void tearDown() throws Exception {
        stop();
    }

    @Test
    public void testModelObjectsPOST() {

        String testUrl = "/test";


        ApiTestUtils.TestResponse res = ApiTestUtils.request("GET", testUrl, null);
        assertEquals(200, res.status);
    }

}