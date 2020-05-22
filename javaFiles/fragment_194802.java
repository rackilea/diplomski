public class Person {
    private final String firstName;
    private final String lastName;

    public Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {return this.firstName;}  
    public String getLastName()  {return this.lastName;}

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}