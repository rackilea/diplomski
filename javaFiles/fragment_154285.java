public class ClassUnderTestTest {
    interface SomeService { int doWork(); }

    class ClassUnderTest {
        private final SomeService service;

        ClassUnderTest() {
            service = new SomeService() {
                @Override public int doWork() { return -1; }
            };
        }

        int useTheService() { return service.doWork(); }
    }

    // This annotation is a variation on @Mocked, which extends
    // mocking to any implementation classes or subclasses of
    // the mocked base type.
    @Capturing SomeService mockService;

    @Test
    public void shouldBeAbleToMaskVariousNumbers() {
        new Expectations() {{ mockService.doWork(); result = 123; }};

        int n = new ClassUnderTest().useTheService();

        assertEquals(123, n);
    }
}