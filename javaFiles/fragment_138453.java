public class Entity {

    public String id;

    @JsonDeserialize(using = RawJsonDeserializer.class)
    public String children;
}