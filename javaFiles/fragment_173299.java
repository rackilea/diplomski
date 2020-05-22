public class JacksonTimezone {

    public static class DataTimeDeserializerTimeZone extends DateTimeDeserializer {
        public static final ThreadLocal<DateTimeZone> TIME_ZONE_THREAD_LOCAL = new ThreadLocal<DateTimeZone>() {
            @Override
            protected DateTimeZone initialValue() {
                return DateTimeZone.getDefault();
            }
        };

        public DataTimeDeserializerTimeZone() {
            super(DateTime.class);
        }

        @Override
        public ReadableDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            return super.deserialize(jp, ctxt).toDateTime().withZone(TIME_ZONE_THREAD_LOCAL.get());
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JodaModule module = new JodaModule();
        module.addDeserializer(DateTime.class,
                (JsonDeserializer) new DataTimeDeserializerTimeZone());
        mapper.registerModule(module);

        DateTime dateTime1 = DateTime.parse("2014-02-03T10:00");
        String json = mapper.writeValueAsString(dateTime1);
        System.out.println(json + " " + TIME_ZONE_THREAD_LOCAL.get());
        System.out.println(mapper.readValue(json, DateTime.class));
        TIME_ZONE_THREAD_LOCAL.set(DateTimeZone.forID("US/Hawaii"));
        System.out.println(mapper.readValue(json, DateTime.class));

    }
}