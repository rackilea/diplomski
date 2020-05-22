public class BlaBlaBlaTestCase extends StrutsSpringTestCase {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public String getContextLocations() {
        return "applicationContext_test.xml";
    }

    @Test
    public void testWhatever() {
                //...
    }
}