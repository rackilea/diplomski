package de.scrum_master.app;

@Entity
public class Person {
    public static final String firstNameEN = "first name";
    public static final String firstNameFR = "prénom";
    public static final String firstNameRU = "и́мя";

    public static final String lastNameEN = "last name";
    public static final String lastNameFR = "nom de famille";
    public static final String lastNameRU = "фами́лия";

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}