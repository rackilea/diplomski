public class Ship<T> {

    private final Class<T> passengerType;
    private ArrayList<T> passengers = new ArrayList<T>();

    public Sheep(ArrayList<T> passengers, Class<T> passengerType) {
        this.passengers = passengers;
        this.passengerType = passengerType;
    }

    public void addPassenger(T object) {
        passengers.add(object);
    }
    // ... rest of class
}