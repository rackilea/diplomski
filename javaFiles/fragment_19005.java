public class CustomMap extends LinkedHashMap<String, Object> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Object convertPrimitive(String key, Object value) {
        switch (key) {
            case "age":
                return new BigInteger(value.toString());
            case "city":
                return value.toString().toLowerCase();
            default:
                return value;
        }
    }

    private Object convertMap(String key, Object value) {
        return OBJECT_MAPPER.convertValue(value, CustomMap.class);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, (value instanceof Map) ? convertMap(key, value) : convertPrimitive(key, value));
    }
}