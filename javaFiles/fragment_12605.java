@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "user", value = ReferenceUser.class),
    @JsonSubTypes.Type(name = "message", value = ReferenceMessage.class),
    @JsonSubTypes.Type(name = "thread", value = ReferenceThread.class)
})

public class Reference {
    int id;
    String name;
}