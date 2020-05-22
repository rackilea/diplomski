public abstract class JsonConfig{

    private JsonConfig(){

    }

    private static final ObjectMapper CONFIGURED_OBJECT_MAPPER;
    private static final JacksonJsonProvider JAX_RS_JSON_PROVIDER;

    static{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        objectMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, true);

        //and just incase you do some web transformaions with jersy or something

        JAX_RS_JSON_PROVIDER = new JacksonJsonProvider(objectMapper);

        CONFIGURED_OBJECT_MAPPER = objectMapper;    
    }

    public static ObjectMapper getObjectMapperInstance(){
        return CONFIGURED_OBJECT_MAPPER;
    }

    public static JacksonJsonProvider getJsonProviderInstance(){
       return return JAX_RS_JSON_PROVIDER
    }
}