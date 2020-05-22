class Entity {

    private long altitude = 123;
    private int speed = 100;

    @CompressedName("a")
    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    @CompressedName("sp")
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}