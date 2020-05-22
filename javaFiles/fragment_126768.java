@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChildADTO.class, name = "child_a"),
        @JsonSubTypes.Type(value = ChildBDTO.class, name = "child_b")
})
 public abstract class ParentDTO {
   // ..
 }