public class PersonWrapper {
    private Person person;

    public PersonWrapper(Person person) {
        this.person = person;
    }

    @override
    public boolean equals(Object other) {
        if (other == null) 
            return false;
        if (other instanceof PersonWrapper) {
            //etc etc, check for equality with other wrappers.
            ...
        }
    }
}