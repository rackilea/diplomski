@JsonCreator
public Pojo(@JsonProperty(value = "string", required = true) String string) {
    if (string == null) {
        throw new IllegalArgumentException("string cannot be null");
    }
    this.string = string;
}