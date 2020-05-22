public final class Person {
    private final String name;
    private final int age;
    private final int birthMonth;

    public Person(String name, int age, int birthMonth) {
        this.name = Objects.requireNonNull(name);
        this.age = age;
        this.birthMonth = birthMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person rhs = (Person) o;
            return name.equals(rhs.name)
                    && age == rhs.age
                    && birthMonth == rhs.birthMonth;
        }
        return false;
    }

    // Any time you override `equals`, you must make a matching `hashCode`.
    // This implementation of `hashCode` is low-quality, but demonstrates
    // the idea.
    @Override
    public int hashCode() {
        return name.hashCode() ^ age ^ birthMonth;
    }
}