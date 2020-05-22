public class Person implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getters and setters are required (I skipped here just to make it shorter)

    // I also have toString() method in my code to get person object nicely outputted
    // where I need it.
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            '}';
    }
}