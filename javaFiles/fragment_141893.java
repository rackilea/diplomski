public class MyTestClass {
    private static String onceForAllTests;

    @AfterClass
    public static void afterClass() {
        onceForAllTests = null; // silly, but just to demonstrate
    }

    @BeforeClass
    public static void beforeClass() {
        onceForAllTests = "This is set once for all tests";
    }

    @Test
    public void sillyTest {
        String someTestValue = "This is set during method";
        assertNotEquals( onceForAllTests, someTestValue );
    }
}