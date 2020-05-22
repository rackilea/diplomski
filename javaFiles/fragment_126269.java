public interface MetaData {
    String getId();
    Map<String, Object> getProperties();
    void setProperties(Map<String, Object> properties);

    @JsonIgnore
    EntityType getEntityType();
}