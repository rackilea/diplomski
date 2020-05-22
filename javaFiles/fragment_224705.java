public class Coordinate{
    private int x;
    private int y;

    //getters and setters, constructor
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Coord)) {
            return false;
        }
        Coordinate coord = (Coordinate) o;
        return coord.x == x &&
                coord.y == y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}