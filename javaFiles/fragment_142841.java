abstract class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() { return name; }

}

class PassengerCar extends Car {

    public PassengerCar() {
        super("Passenger Car");
    }

}

class CoalCar extends Car {

    public CoalCar() {
        super("Coal Car");
    }

}