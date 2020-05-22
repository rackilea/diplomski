public class TestClass {
    TestService testService;
    public void doTest() {
        System.out.println(testService.getString());
    }
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
public class TestService {
    public String getString() {
        return "Hello world";
    }
}
@Test
public void toTest() {
    TestService testService = Mockito.mock(TestService.class);
    Mockito.when(testService.getString()).thenReturn("Hello Squirrel");
    TestClass testClass = new TestClass();
    testClass.setTestService(testService);
    testClass.doTest();
}