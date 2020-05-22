// @Component
public static class TestControllerTestApplication implements SparkApplication {

    // #1 debug point 1 in IDE shows this as NULL
    // @Autowired PersonRoute personRoute;

    @Override
    public void init() {
        // new SimpleController(this.personRoute);
    }
}