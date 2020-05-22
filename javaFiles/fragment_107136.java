public class Truck {
    private WheelImplementation wheel;

    Truck(){
        this.wheel = new WheelImplementation(/*...initial color...*/);
    }

    Wheel getWheel() {
        return this.wheel;
    }
}