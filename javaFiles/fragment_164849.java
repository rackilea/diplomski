public class Person {
    private String firstName;
    private String lastName;

    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
    }
    ...
}