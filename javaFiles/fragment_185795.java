enum Sensor {
    ACCELEROMETER_X("AccX"),
    // Other constants
    ;

    private final String abbreviation;

    private Sensor(final String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}