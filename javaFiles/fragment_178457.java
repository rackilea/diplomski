public class MyCustomObjectMapper extends ObjectMapper {
    public MyCustomObjectMapper() {
        SimpleModule module = new SimpleModule("My Module", new Version(1, 0, 0, "SNAPSHOT"));
        module.addSerializer(new CustomSerializer());
        module.addSerializer(new CustomSerializer2());
        // etc
        this.registerModule(module);
    }
}