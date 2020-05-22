public interface VehicleVisitor<T> {
    T visitCar(Car car);
    T visitTruck(Truck truck);
    T visitBike(Bike bike);
}

public abstract class Vehicle {
    public abstract <T> T accept(VehicleVisitor<T> visitor);
}

public class Car extends Vehicle {
    @Override
    public <T> T accept(VehicleVisitor<T> visitor) {
        return visitor.visitCar(this);
    }
}

// same for Bike and Truck