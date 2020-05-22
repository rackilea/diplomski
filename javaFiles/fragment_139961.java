public class TheMentionedClassIntegrationTest {

    @Inject
    private TheMentionedClass theMentionedClass;

    @Before
    public void setUp() {
        ServiceLocator locator = ServiceLocatorUtilities.bind(new YourBinder());
        locator.inject(this);
    }

    @Test
    public void testProcessMethod() {
        assertNotNull(theMentionedClass);
    }
}