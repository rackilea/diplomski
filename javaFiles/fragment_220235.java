public abstract class GenericMessageMixIn<T> {
    @JsonCreator
    public GenericMessageMixIn(
            @JsonProperty("payload") T payload,
            @JsonProperty("headers") Map<String, Object> headers
    ){}
}