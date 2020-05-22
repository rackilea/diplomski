public class Person {
    private String lastName;
    private String firstName;
    private String email;
    private String town;
    @JsonAny
    private Map<String, Object> otherProperties;

    // Constructors, getters/setters
}