@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class TimeSeries {

    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonDeserialize(using = MetaDataDeserializer.class)
    @Getter
    @Setter
    @NoArgsConstructor
    static class MetaData {
        private String information;
        private String symbol;
    }

    private static class MetaDataDeserializer extends StdDeserializer<MetaData> {
        protected MetaDataDeserializer() {
            super(MetaData.class);
        }

        @Override
        public MetaData deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
            MetaData metaData = new MetaData();
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
                    System.out.println(fieldName);

                    //jsonToken =
                    parser.nextToken();

                    if (fieldName.toLowerCase().matches(".*information")) {
                        metaData.setInformation(parser.getValueAsString());
                    }
                }
            }

            return metaData;
        }
    }
}