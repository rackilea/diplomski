public class DataLoader {

    // Location has data members X and Y
    private Map<Integer, Location> locations;

    public synchronized Location getLocation(int index) {

        if (locations == null) {
            locations = new HashMap<>();
            // load the map
        }

        return locations.get(index);
    }
}