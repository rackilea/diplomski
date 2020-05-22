@Test
public void newDeserializer() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    SimpleModule module = new SimpleModule("DeepThirdPartyClass subclass override", new Version(1, 0, 0, "FINAL", "com.example", "deep-third-party-class-override"));
    module.addDeserializer(DeepThirdPartyClass.class, new JsonDeserializer<DeepThirdPartyClass>() {
        @Override
        public DeepThirdPartyClass deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return p.readValueAs(MyClass.class);
        }
    });
    objectMapper.registerModule(module);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    String json = "{\n" +
            "  \"middle\": {\n" +
            "    \"fieldOne\": \"valueOne\",\n" +
            "    \"fieldTwo\": {\n" +
            "      \"fieldThree\": \"valueThree\"\n" +
            "    }\n" +
            "  }\n" +
            "}\n";

    ThirdPartyClass thirdPartyClass = objectMapper.readValue(json, ThirdPartyClass.class);
}

public class ThirdPartyClass {
    public DeepThirdPartyClass middle;
}

public class InnerClass {
    public String fieldThree;
}