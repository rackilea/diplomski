class NamedThing {
    String name;
}

class Person {
    private  NamedThing namedThing;
    // Here is the view method
    public NamedThing asNamedThing() {
        return namedThing;
    }
    // Here is a convenience method for accessing name directly
    public String getName() {
        return namedThing.name;
    }
    Date dateOfBirth;
}