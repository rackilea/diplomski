public static void main(String[] args) throws IOException {
    ObjectMapper mapper1 = new ObjectMapper();
    String person1 = "{\"firstName\":null,\"lastName\":null,\"address\":null}";
    Person deserialized1 = mapper1.readValue(person1,Person.class);

    ObjectMapper mapper2 = new ObjectMapper();
    mapper2.addMixIn(Person.class, PersonMixin.class);
    String person2 = "{\"fName\":null,\"lName\":null,\"addr\":null}";
    Person deserialized2 = mapper2.readValue(person2,Person.class);
}

public static class Person {
    @JsonProperty("firstName")
    String firstName;
    @JsonProperty("lastName")
    String lastName;
    @JsonProperty("address")
    String address;

}

public class PersonMixin {
    @JsonProperty("fName")
    String firstName;
    @JsonProperty("lName")
    String lastName;
    @JsonProperty("addr")
    String address;
}