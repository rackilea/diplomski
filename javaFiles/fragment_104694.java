public interface FooMixin {
    @JsonSerialize
    Map<String, Bar> getBarsMap();
    @JsonDeserialize
    void setBarsMap(Map<String, Bar> barsMap);
}