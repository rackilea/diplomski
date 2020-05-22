public class CoordinateSet {
    private HashSet<Long> coordinates = new HashSet<>();

    public void add(int x, int y) {
        coordinates.add((x | (long) y << 32));
    }

    public boolean contains(int x, int y) {
        return coordinates.contains((x | (long) y << 32));
    }
}