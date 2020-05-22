public class Newsletter {

    private final Map<String, String> properties = new HashMap<>();

    @JsonAnySetter
    public void addProperty(String name, String value) {
        properties.put(name, value);
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}