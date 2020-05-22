public class Coordinate {
    private int latitude;
    private int longitude;

    public Coordinate(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public boolean equals(Object value) {
        boolean equals = false;
        if (value instanceof Coordinate) {
            Coordinate coord = (Coordinate) value;
            equals = getLatitude() == coord.getLatitude() && getLongitude() == coord.getLongitude();
        }
        return equals;
    }

    //good practice to override hashcode when you override equals
    public int hashcode() {
        int hash = 7;
        hash = 89 * hash + this.latitude;
        hash = 89 * hash + this.longitude;
        return hash;
    }
}