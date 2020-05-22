@JsonAutoDetect(fieldVisibility = Visibility.NONE)
public interface MyWrapper {
    @JsonIgnore
    String getMyField();

    // annotation to deserialize
    @JsonProperty("my_field")
    void setMyField(String f);
}