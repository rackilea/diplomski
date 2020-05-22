public class SomeTest
    SomeObject so;

    @Before
    public void setUp() {
        so = new SomeObject();
    }

    @Test
    public void TestSomeFlow() {
        try {
            so.init();
        // must catch in order to avoid a compilation error
        } catch (InitExceptionIDontCareAbout e) {
            fail ("init failed");
        }

        try {
            so.doSomething();
        // must catch in order to avoid a compilation error
        } catch (SomeOtherExceptionIDontCareAbout e) {
            fail ("doSomething failed");
        }

        assertTrue ("doSomething didn't work", so.isSomethingDone());
    }
}