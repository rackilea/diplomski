public class MyResourceConfig extends ResourceConfig {

    public MyResourceConfig() {
        // ... other registrations ...

        register(JacksonFeature.class);
    }
}