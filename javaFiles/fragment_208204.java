package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty firstName ;
    private final StringProperty lastName ;

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(this, "firstName", firstName);
        this.lastName = new SimpleStringProperty(this, "lastName", lastName);
    }

    public final StringProperty firstNameProperty() { return firstName; }
    public final String getFirstName() { return firstNameProperty().get(); }
    public final void setFirstName(final String firstName) { firstNameProperty().set(firstName); }
    public final StringProperty lastNameProperty() { return lastName; }
    public final String getLastName() { return lastNameProperty().get(); }
    public final void setLastName(final String lastName) { lastNameProperty().set(lastName); }
}