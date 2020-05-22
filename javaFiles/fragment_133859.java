public class CustomObjectMapper1 extends ObjectMapper {
    public CustomObjectMapper1() {
        super();
        super.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        super.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        super.setDateFormat(df);
    }
    public byte[] generateJson(Object value) throws IOException, JsonGenerationException, JsonMappingException {
        Hibernate4Module hm = new Hibernate4Module();
        hm.configure(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION, false);
        hm.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, false);
        return super.registerModule(hm).writeValueAsBytes(value);
    }
}