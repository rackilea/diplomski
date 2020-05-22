public class CustomObjectMapper2 extends ObjectMapper {
    public CustomObjectMapper2() {
        super();
        super.setDateFormat(df);
    }
    public byte[] generateJson(Object value) throws IOException, JsonGenerationException, JsonMappingException {
        Hibernate4Module hm = new Hibernate4Module();
        return super.registerModule(hm).writeValueAsBytes(value);
    }
}