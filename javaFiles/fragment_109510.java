import org.junit.Assert;
import org.junit.Test;

public class MyObjectTest {
    @Test
    public void testMyObjectMethod() {
        // Create the object that contains your method (not in the sample you provided)
        MyObjectToTest obj = new MyObjectToTest();

        // Check that for a null status you get some result (assuming you want this)
        Assert.assertNotNull(obj.findOverviewByStatus(null));

        // Lets assume that a null status returns an empty array, add a check for it
        Assert.assertTrue("null parameter size should be 0", obj.findOverviewByStatus(null).size() == 0);

        //etc...
    }
}