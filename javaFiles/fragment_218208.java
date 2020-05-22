public void start() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.getSerializationConfig().addMixInAnnotations(Something.class, Nested.class);
    mapper.getDeserializationConfig().addMixInAnnotations(Something.class, Nested.class);
    System.out.println(mapper.writeValueAsString(new Something("Name", 12, "male", new NestedImpl("name", null))));
}
public final class Something {
    private final String name;
    private int age;
    private String gender;
    // thats your interest thing
    public Nested nested;

    public Something(String name, int age, String gender, Nested nested) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nested = nested;
    }
    String getName() {
        return name;
    }
    Nested getNested() {
        return nested;
    }
}
public abstract class Nested {
    @JsonProperty("name-ext")
    abstract String getName();
    @JsonProperty("interest-ext")
    abstract Nested getNested();
}
public class NestedImpl extends Nested {
    private String name;
    private Nested nested;
    private NestedImpl(String name, Nested nested) {
        this.name = name;
        this.nested = nested;
    }
    @Override
    String getName() {
        return name;
    }
    @Override
    Nested getNested() {
        return nested;
    }
}