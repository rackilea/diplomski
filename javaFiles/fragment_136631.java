public class Strawberry implements Edible {
    int cals;
    Location location;

    public Strawberry(int c, Location l) {
        cals = c;
        location = l;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}