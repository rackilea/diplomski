public class Car extends Vehicle {
    private Car(String name){
        super(name);
    }

    public static Car of(Car a) {
        Objects.requireNonNull(a, "a is required");
        return new Car(a.getName());
    }
}