public class RepeatTests extends TestCase {

public static Test suite() {
    TestSuite suite = new TestSuite(RepeatTests.class.getName());

    for (int i = 0; i < 10; i++) {              
    suite.addTestSuite(YourTest.class);             
    }

    return suite;
}
}