public class InjectionTest {

    @Inject
    private TestController controller;

    @Before
    public void setUp() {
        final Binder b = new AbstractBinder() {
            @Override
            public void configure() {
                bindAsContract(TestController.class);
            }
        };
        final ServiceLocator locator = ServiceLocatorUtilities.bind(new TestBinder(), b);
        locator.inject(this);
    }

    @Test
    public void doTest() {
        assertNotNull(controller);
        String response = controller.get();
        assertEquals("Hello Tests", response);
    }
}