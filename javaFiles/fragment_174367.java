@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper;

    public JacksonConfig() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null));
        module.addSerializer(Money.class, new MoneySerializer());
        module.addSerializer(LocalDate.class, new DateSerializer());
        objectMapper.registerModule(module);
    }

    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }

}