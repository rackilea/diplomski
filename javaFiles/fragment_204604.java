public class JerseySpringResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        // Enable logging.
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        // Create an instance of MyApplication ...
        return new MyApplication()
                // ... and pass "contextConfigLocation" property to Spring integration.
                .property("contextConfigLocation", "classpath:helloContext.xml");
    }

    @Test
    public void testJerseyResource() {
        // Make a better test method than simply outputting the result.
        System.out.println(target("spring-hello").request().get(String.class));
    }
}