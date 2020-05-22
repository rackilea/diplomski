public class DateDeserializer extends JsonDeserializer<Map<String, Object>> {

    private TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {};

    @Override
    public Map<String, Object> deserialize(JsonParser p, DeserializationContext ctxt, Map<String, Object> target) throws IOException, JsonProcessingException {

        Map<String, Long> map = new ObjectMapper().readValue(p, typeRef);

        for(Entry<String, Long> e : map.entrySet()){

            Long value = e.getValue();
            String key = e.getKey();

            if(value instanceof Long){ // or if("date".equals(key)) ...
                target.put(key, new Date(value));
            } else {
                target.put(key, value); // leave as is
            }

        }

        return target;
    }

    @Override
    public Map<String, Object> deserialize(JsonParser paramJsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return this.deserialize(paramJsonParser, ctxt, new HashMap<>());
    }

}