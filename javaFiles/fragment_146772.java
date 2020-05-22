public class class1Test {

    @Resource
    MyService myService;

    @Resource
    Class1 class1;

    public void setUPTest() {
        MockitoAnnotations.initMocks(this);
    Mockito.doReturn(123).when(myService).doSomethingElse("someString");
    }

    @Test
    public void methodToBeTestedTest() {
        this.setUPTest();
            ...
            class1.methodToBeTested();
    }

}