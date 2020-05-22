public class MyDes extends JsonDeserializer<ContainedObject> {

        @Override
        public String deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
            //read the JsonNode and determine if it is empty JSON object
            //and if so return null

            if (node is empty....) {
                return null;
            }
            return node;
        }

    }