public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    /**
     * copy constructor
     */
    protected Person(Person p) {
        this.name = p.name;
    }

    // ...
}

public class Employee extends Person {
    private String badge;

    public Employee(Person p, String badge) {
        super(p);
        this.badge = badge;
    }

    // ...
}