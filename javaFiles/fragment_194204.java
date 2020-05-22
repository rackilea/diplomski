public class AddressBook {

//Instance Variables
private Name name;
private Email email;
private Phone phone;

//Constructor
public AddressBook() {
    name = new Name();
    email = new Email();
    phone = new Phone();
}

// more Constructors

public void setName(Name name) {
    this.name = name
}

public Name getName() {
    return name;
}
// more getters and setters