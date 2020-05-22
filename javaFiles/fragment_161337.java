public class Person {

    private final String id;

    public Person(String id) {
        this.id = id;
    }

    public Person() {
        this.id = UUID.randomUUID().toString();
    }

}