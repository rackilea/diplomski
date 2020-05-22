public class Person {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName");

    private StringProperty lastName = new SimpleStringProperty(this, "lastName");

    public Person(String firstName, String lastName) {
        setFirsName(firstName);
        setLastName(lastName);
    }

    public void setFirsName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

}