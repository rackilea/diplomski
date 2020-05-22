public interface Vehicle {
    public void move();
}

public class Bicycle implements Vehicle {
    int wheels;
    public Bicycle {
        wheels = 2;
    }
    @Override
    public void move() {
        //implementation for steering/pedaling the bike
    }
}

public class Car implements Vehicle {
    int wheels;
    int fuelCap;
    public Car {
        wheels = 4;
        fuelCap = 12; //12 gallon tank
    }
    @Override
    public void move() {
        //logic to drive the car
    }
}