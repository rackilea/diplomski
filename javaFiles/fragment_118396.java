public interface PostConstruct {
    void postConstruct();
}

public class Customer implements PostConstruct {
    //mapping 

    private Map<String, Object> additionalFields = new HashMap<>();

    @JsonAnySetter
    public void setAdditionalValue(String key, Object value) {
        additionalFields.put(key, value);
    }

    @Override
    public void postConstruct() {
        address = new Address();
        address.setStreet(String.valueOf(additionalFields.get("street")));
        address.setPostalcode(String.valueOf(additionalFields.get("postalcode")));
    }
}


public static class PostConstructDeserializer extends DelegatingDeserializer {
    private final JsonDeserializer<?> deserializer;

    public PostConstructDeserializer(JsonDeserializer<?> deserializer) {
        super(deserializer);
        this.deserializer = deserializer;
    }

    @Override
    protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> newDelegatee) {
        return deserializer;
    }

    @Override
    public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        Object result = _delegatee.deserialize(jp, ctxt);
        if (result instanceof PostConstruct) {
            ((PostConstruct) result).postConstruct();
        }
        return result;
    }
}


//using of post construct deserializer

    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.setDeserializerModifier(new BeanDeserializerModifier() {
        @Override
        public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config,
                                                      BeanDescription beanDesc,
                                                      final JsonDeserializer<?> deserializer) {
            return new PostConstructDeserializer(deserializer);
        }
    });
    mapper.registerModule(module);