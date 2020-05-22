public class Wrapper {

    private String type;

    @JsonTypeInfo(use = Id.NAME, property = "type", include = As.EXTERNAL_PROPERTY)
    @JsonSubTypes(value = { 
            @JsonSubTypes.Type(value = FooData.class, name = "Foo"),
            @JsonSubTypes.Type(value = BarData.class, name = "Bar") 
    })
    private AbstractData data;

    // Getters and setters
}