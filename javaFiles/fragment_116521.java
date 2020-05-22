@JsonSerialize(using = SomeClassSerializer.class)
public static class SomeClass {
    private String id;
    @JsonProperty("key-value")
    private Map<String, Object> keyValue;

    public SomeClass(String id, Map<String, Object> keyValue) {
        this.id = id;
        this.keyValue = keyValue;
    }
    public String getId() { return id; }
    public Map<String, Object> getKeyValue() { return keyValue; }
}