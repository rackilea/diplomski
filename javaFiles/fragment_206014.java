@Provider
@Produces({MediaType.APPLICATION_JSON, "application/customType.v1+json"})
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {

    public JacksonJsonProvider() {

        ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .registerModule(new JodaModule())
            .setDateFormat(new RFC3339DateFormat());

        setMapper(objectMapper);
    }
}