@Service
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        this.registerModule(new JodaModule());
    }
}