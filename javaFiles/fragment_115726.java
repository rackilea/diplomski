public class Person implements Streamable {
    // fields, visibility doesn't matter
    private String name;
    private int age;

    private Person() {}        // default no-args constructor is required

    public Person( String name, int age ) {
        this.name = name; this.age = age;
    }

    // getters, setters are optional...
}