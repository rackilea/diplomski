public class MyResourceConfig extends ResourceConfig {
    public MyResourceConfig() {
        register(JsonMappingExceptionHandler.class, 1);
        register(JsonParseExceptionHandler.class, 1);
        // ...
    }
}