@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SubType1.class, name = "SubType1"),
        @JsonSubTypes.Type(value = SubType2.class, name = "SubType2")})
public interface Common {
     @JsonIgnore
     String getType();
}