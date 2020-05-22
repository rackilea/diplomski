public class JacksonMapping {
    public static final String JSON = "...";

    public static class Attributes {
        public String type;
        public URI url;
    }

    public static class Address {
        public String city;
        public String country;
        public String state;
        public Integer stateCode;
        public String street;
        private final Map<String, Object> otherAttributes = new HashMap<>();

        @JsonAnySetter
        public void setProperty(String name, Object value) {
            otherAttributes.put(name, value);
        }

        @JsonAnyGetter
        public Map<String, Object> getOtherAttributes() {
            return otherAttributes;
        }
    }

    public static class Record {
        @JsonProperty("Id")
        public String id;
        @JsonProperty("Name")
        public String name;
        public Attributes attributes;
        @JsonProperty("Address")
        public Address address;
        @JsonProperty("Phone")
        public String phone;
    }

    public static class RecordList {
        public List<Record> records;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RecordList recordList = mapper.readValue(JSON, RecordList.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(recordList));
    }

}