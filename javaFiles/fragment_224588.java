@JsonCreator
public FooBar(
        @JsonProperty("blargs")
        @JsonDeserialize(using = XyzDeserializer.class) Map<Integer, String> xyz) {
    this.xyz = xyz;
}