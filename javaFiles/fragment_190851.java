@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "AContent", value = EntityA.class),
        @JsonSubTypes.Type(name = "BContent", value = EntityB.class),
})
public class Entity {
    ...
}