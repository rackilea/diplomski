public class Common {
     @Before
     public void setUp() {
         ...
     }
     @After
     public void tearDown() {
         ...
     }
}

public class MyTest extends Common {
    @Test
    public void test() {
        // Common.setUp() will have been run before this test
        // Common.tearDown() will run after the test
    }
}