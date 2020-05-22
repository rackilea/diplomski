@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes(
    {@JsonSubTypes.Type(value = MyObject1.class, name = "OBJECT_1"),
            @JsonSubTypes.Type(value = MyObject2.class, name = "OBJECT_2"),
            @JsonSubTypes.Type(value = MyObject3.class, name = "OBJECT_3")}
)
public interface MyObjectInterface {}