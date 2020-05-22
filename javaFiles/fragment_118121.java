public class Vehicle<P> {

    List<P> passengers = new ArrayList<>();

    public <T extends P> void addPassenger(T pass) {
        passengers.add(pass);
    }
}