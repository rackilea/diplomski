public class BaseTest {
    @Before
    public void setUp(){
        System.out.println("before called");
    }
}

public class Test1 extends BaseTest {
    @Test
    public void test() {
        Assert.assertTrue(true);
        System.out.println("Test1");
    }   
}

public class Test2 extends BaseTest {
    @Test
    public void test() {
        Assert.assertTrue(true);
        System.out.println("Test1");
    }   
}