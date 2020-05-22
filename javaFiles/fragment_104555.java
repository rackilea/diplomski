public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private MaritalStatus status;
    private int age;

    public Person(final int id, final String firstName, final String lastName, final MaritalStatus status, final int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", age=" + age +
                '}';
    }
}