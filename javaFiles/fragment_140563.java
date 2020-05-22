public class Person {

    public Person() {
    }

    private String firstName = "default";
    private String lastName = "default";
    private Integer activeState = 7;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getActiveState() {
        return activeState;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}