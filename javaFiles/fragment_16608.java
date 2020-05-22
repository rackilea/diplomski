@JsonAdapter(PersonSerializer.class)
class Person {
    private final String name;
    Person(final String name) {
        // Some validation...
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}