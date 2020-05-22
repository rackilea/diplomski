public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Optional<Address> address;
    private Optional<String> phone;

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, Optional.empty(), Optional.empty());
    }

    @JsonCreator
    public Person(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("age") int age,
            @JsonProperty("address") Optional<Address> address,
            @JsonProperty("phone") Optional<String> phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }