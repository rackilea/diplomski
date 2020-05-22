class Root {

    @JsonPrimitiveName("value")
    @JsonDeserialize(using = PrimitiveOrPojoJsonDeserializer.class)
    private Foo foo;

    @JsonPrimitiveName("thing")
    @JsonDeserialize(using = PrimitiveOrPojoJsonDeserializer.class)
    private Fuzz fuzz;

    // getters, setters
}