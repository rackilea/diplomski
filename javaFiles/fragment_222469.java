public class MyTest extends JerseyTestNg {

    // rest omitted

    protected Application configure() {

        // rest omitted

        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
    }