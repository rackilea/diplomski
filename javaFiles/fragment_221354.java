class Pojo<T> {
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public T value;
    public List<T> otherStuff;
    // constructor

    @JsonCreator
    public static <T> Pojo<T> jsonCreator(
            @JsonProperty("value") T value,
            @JsonProperty("otherStuff") JsonNode otherStuffRaw) {
        JavaType listType = or.getTypeFactory()
                              .constructParametricType(List.class, value.getClass());
        return new Pojo<T>(
            value,
            or.forType(listType).readValue(otherStuffRaw)
        );
    }
}