public class TestClassTest {
    //class under test
    TestClass test = new TestClass();

    @org.junit.Test
    public void testMethod() throws Exception {
        HttpServer mockServer = Mockito.mock(HttpServer.class);
        test.setServer(mockServer);
        //set up mock, test and verify
    }
}