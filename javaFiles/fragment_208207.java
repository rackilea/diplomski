package application;

public class PersonBuilder {

    private String firstName ;
    private String lastName ;

    private PersonBuilder() {   }

    public static PersonBuilder create() {
        return new PersonBuilder();
    }

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName ;
        return this ;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName ;
        return this ;
    }

    public Person build() {
        return new Person(firstName, lastName);
    }
}