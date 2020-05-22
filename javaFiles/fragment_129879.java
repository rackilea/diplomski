public class Person {
    // members, constructors, etc.

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person)) {
            return false;
        }
        return name.equals(((Person)other).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}