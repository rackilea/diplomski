class Feed {
    Long id;
    String title;
    String text;
    Short type;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_POPERTY, propery = "type")
    @JsonSubTypes({
        @JsonSubTypes.Type(value = Foo.class, name = "1"),
        @JsonSubTypes.Type(value = Bar.class, name = "2")
    })
    Object object;
}