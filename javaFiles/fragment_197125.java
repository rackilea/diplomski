public final class Car {

    private final List<Door> doors;
    private final Engine engine;

    public Car(final Engine engine, final List<Door> doors) {
        this.engine = engine;
        this.doors = doors;
    }

    // Getters ONLY
}