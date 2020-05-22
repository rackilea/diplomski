public class Truck implements Relatable {

    private int capacity;
    private int horsepower;

    public int isLargerThan(Relatable other) {
        if (other instanceof Truck) {
            Truck otherTruck = (Truck)other;
            return Integer.signum(capacity - otherTruck.capacity);
        } else if (other instanceof Car) {
            Car otherCar = (Car)other;
            return Integer.signum(horsepower - otherCar.getHorsepower());
        } else {
            // Maybe throw exception
        }
    }