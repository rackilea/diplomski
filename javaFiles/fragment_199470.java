public class Foo {

    private String            name;

    @JsonProperty
    @JsonDeserialize(using = DateDeserializer.class)
    private Map<String, Object> dates;

    [...] // getter, setter, equals, hashcode
}