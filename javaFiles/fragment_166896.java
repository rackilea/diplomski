public class TestControllerTest extends AbstractControllerTest {

    public TestControllerTest() {
        super(TestController.class);
    }

    @Inject
    private TestController controller;

    @Test
    public void doTest() {
        assertNotNull(controller);
        assertEquals("Hello Tests", controller.get());
    }
}