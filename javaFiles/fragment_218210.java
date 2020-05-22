ObjectMapper mapper = new ObjectMapper();
mapper.getSerializationConfig().addMixInAnnotations(Something.class, Mixin.class);
mapper.getSerializationConfig().addMixInAnnotations(Nested.class, NestedMixin.class);
mapper.getDeserializationConfig().addMixInAnnotations(Something.class, Mixin.class);
mapper.getDeserializationConfig().addMixInAnnotations(Nested.class, NestedMixin.class);

Nested nested = new Nested();
nested.setName("Nested");
nested.setNumber(12);

Something some = new Something();
some.setName("Something");
some.setAge(24);
some.setGender("Male");
some.setNested(nested);

String json = mapper.writeValueAsString(some);
System.out.println(json);
Something some2 = mapper.readValue(json, Something.class);
System.out.println("Object: " + some2);

public abstract class Mixin {

    @JsonProperty("name")
    private String _name;
    @JsonProperty("age")
    private int _age;
    @JsonProperty("gender")
    private String _gender;
    @JsonProperty("interest")
    private Nested nested;
}

public class Something {
    private String _name;
    private int _age;
    private String _gender;
    private Nested nested;

    // You have to provide Setters and Getters!!
}

public abstract class NestedMixin {

    @JsonProperty("nameNested")
    private String name;
    @JsonProperty("numberNested")
    private int number;
}

public class Nested {
    private String name;
    private int number;

    // You have to provide Setters and Getters!!
}