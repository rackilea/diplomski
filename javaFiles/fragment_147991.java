@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
        defaultImpl = EmptyThing.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Thing.class, name = "Thing"),
        @JsonSubTypes.Type(value = FancyThing.class, name = "FancyThing")
})
public class Thing {

...

}

public class EmptyThing extends Thing {

    public EmptyThing(String s) {
        // Jackson wants a single-string constructor for the default impl
    }
}