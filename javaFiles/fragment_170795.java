public class Spring38TestCase extends TestCase {

    private Controller controller;
    private ApplicationContext context;

    @Override
    protected void setUp() throws Exception {
        //Initializing spring application context.
        context = new ClassPathXmlApplicationContext("beans.xml");
        //Setting fields in test case explicitly in case of auto wiring
        controller = context.getBean(Controller.class);
    }

    public void testController() {
        assertEquals("Hello", controller.message());
    }
}