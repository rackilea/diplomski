public abstract class AbstractControllerTest {

    protected ServiceLocator locator;
    private final Class<?> controllerClass;

    protected AbstractControllerTest(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    @Before
    public void setUp() {
        final AbstractBinder binder = new AbstractBinder() {
            @Override
            public void configure() {
                bindAsContract(controllerClass);
            }
        };
        locator = ServiceLocatorUtilities.bind(new TestBinder(), binder);
        locator.inject(this);
    }

    @After
    public void tearDown() {
        if (locator != null) {
            locator.shutdown();
        }
    }
}