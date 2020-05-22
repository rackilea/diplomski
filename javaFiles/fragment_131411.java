public abstract class BaseTest extends TestCase {

    public void setUp(){
        System.out.println("before called");
    }
}

public class Test1 extends BaseTest {

    public void test() {
        Assert.assertTrue(true);
        System.out.println("Test1");
    }   
}

public class Test2 extends BaseTest {

    public void test() {
        Assert.assertTrue(true);
        System.out.println("Test1");
    }   
}