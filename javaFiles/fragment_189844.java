public class CountryCodeSerializer extends JsonSerializer<CountryCode> {
       @Override
        public void serialize(CountryCode value, JsonGenerator generator, SerializerProvider provider)
                throws IOException, JsonProcessingException {

            if (null == value) {
                throw new IllegalArgumentException("CountryCode is null");
            } else {
                generator.writeString(value.toString());
            }
        }        
    }