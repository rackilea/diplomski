public class JacksonPolymorphic {
    public static String JSON = "{\n" +
            "  \"facility-no\": \"2011\",\n" +
            "  \"standard-counter\": [\n" +
            "    {\n" +
            "      \"id\": \"0\",\n" +
            "      \"type\": \"0\",\n" +
            "      \"text\": \"Gebucht\",\n" +
            "      \"free\": \"0\",\n" +
            "      \"present\": \"0\",\n" +
            "      \"percent\": \"100\",\n" +
            "      \"max\": \"0\",\n" +
            "      \"status\": \"Frei\",\n" +
            "      \"status-value\": \"0\"\n" +
            "    }\n" +
            "]\n" +
            "}";

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    public static abstract class Counter {
        private final String id;

        public Counter(String id) {
            this.id = id;
        }
    }

    public static class Counters {
        private final String facilityId;
        private final List<Counter> counters;

        public Counters(@JsonProperty("facility-no") String facilityId,
                        @JsonProperty("standard-counter") List<Counter> counters) {
            this.facilityId = facilityId;
            this.counters = counters;
        }

        @Override
        public String toString() {
            return "Counters{" +
                    "facilityId='" + facilityId + '\'' +
                    ", counters=" + counters +
                    '}';
        }
    }

    @JsonTypeName("0")
    public static class XCounter extends Counter {
        private final String text;
        private final int free;
        private final int present;
        private final float percent;
        private final int max;
        private final String status;
        private final int statusValue;

        public XCounter(@JsonProperty("id") String id,
                        @JsonProperty("text") String text,
                        @JsonProperty("free") int free,
                        @JsonProperty("present") int present,
                        @JsonProperty("percent") float percent,
                        @JsonProperty("max") int max,
                        @JsonProperty("status") String status,
                        @JsonProperty("status-value") int statusValue) {
            super(id);
            this.text = text;
            this.free = free;
            this.present = present;
            this.percent = percent;
            this.max = max;
            this.status = status;
            this.statusValue = statusValue;
        }

        @Override
        public String toString() {
            return "XCounter{" +
                    "text='" + text + '\'' +
                    ", free=" + free +
                    ", present=" + present +
                    ", percent=" + percent +
                    ", max=" + max +
                    ", status='" + status + '\'' +
                    ", statusValue=" + statusValue +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(XCounter.class);
        System.out.println(mapper.readValue(JSON, Counters.class));
    }

}