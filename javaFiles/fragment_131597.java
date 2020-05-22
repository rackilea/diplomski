public class TypeObjectPair {

    private Map<String, Object> data = new HashMap<>();

    public TypeObjectPair(String key, Object value) {
        data.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }
}