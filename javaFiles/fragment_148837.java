public class MyTestClass {
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            // Handle logging of failing tests
            System.out.println("Fail!");
        }

        @Override
        protected void succeeded(Description description) {
            // Handle logging of succeeding tests
            System.out.println("Success!");
        }
    };

    @BeforeClass
    public static void setup() {
        //Some setup before all test methods
    }

    @AfterClass
    public static void cleanup() {
        // Some cleanup after all test methods
    }

    @Before
    public void register() {
        // Some setup before each test method
    }

    @Test
    public void succeedingTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void failingTest() {
        Assert.assertTrue(false);
    }
}