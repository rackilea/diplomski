private final Map<String, JsonNode> properties = new HashMap<String, JsonNode>();

@JsonAnyGetter
public Map<String, JsonNode> getProperties() {
    return properties;
}

@JsonAnySetter
public void setProperty(String key, JsonNode value) {
    properties.put(key, value);
}