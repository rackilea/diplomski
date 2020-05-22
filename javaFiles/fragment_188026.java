public void setFirstName(String firstName) {
    this.firstName = firstName;
    if(lastName != null) {
        fullName = firstName + " " + lastName);
    }
}

public void setLastName(String lastName) {
    this.lastName = lastName;
    if(firstName != null) {
        fullName = firstName + lastName;
    }
}