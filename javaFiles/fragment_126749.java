public class LocationComparator implements Comparator<Location>{
    @Override
    public int compare(Location object1, Location object2) {
        return (int)object1.distanceTo(object2);
    }
}