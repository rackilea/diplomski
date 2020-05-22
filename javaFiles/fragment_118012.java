public class Car {
    // attribute
    private final String name;

    // Constructor
    public Car(final String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // Override of toString
    @Override
    public String toString() {
        return name;
    }
}