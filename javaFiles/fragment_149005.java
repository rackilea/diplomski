@RunWith(Suite.class)
@SuiteClasses({ Test1.class, Test2.class })
public class TestSuite {
    private static boolean initialized;
    @BeforeClass
    public static void setup (){
        if(initialized)
            return;
        initialized = true;
        System.out.println("setup");
        // essential stuff for Test1#someTest
    }

    public static class Test1{
    @BeforeClass
        public static void setup (){
            TestSuite.setup();
       }
        @Test
        public void someTest(){
            System.out.println("someTest");
        }
    }
}