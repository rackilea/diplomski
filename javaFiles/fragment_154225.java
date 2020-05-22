public class Position {
    private final double latitude;
    private final double longitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distanceTo(Position other) {
        ...
    }
}

public class City {
    private final String name;
    private final Position position;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.position = new Position(latitude, longitude);
    }

    public double distanceTo(City other) {
        return this.position.distanceTo(other.position);
    }
}