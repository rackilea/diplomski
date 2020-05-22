public class SomeTest
    SomeObject so;

    @Before
    public void setUp() {
        so = new SomeObject();
    }

    // Any exception throwm will mean the test did not succeed
    @Test
    public void TestSomeFlow() throws Exception {
        so.init();
        so.doSomething();

        assertTrue ("doSomething didn't work", so.isSomethingDone());
    }
}