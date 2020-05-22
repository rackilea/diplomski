public class CustomObjectMapperBuilder extends Jackson2ObjectMapperBuilder
{
    @Override
    public void configure(ObjectMapper objectMapper)
    {
        super.configure(objectMapper);

        SimpleModule module = new SimpleModule();
        module.addSerializer(Selective.class, new SelectiveSerializer());

        objectMapper.registerModule(module)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));
    }
}