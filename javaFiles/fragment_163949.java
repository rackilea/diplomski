private static class Car {
    private String make;
    private String colour;

    public Car(String make, String colour) {
        this.make = make;
        this.colour = colour;
    }

    public String getMake() {

        return make;
    }

    @Override
    public String toString() {
        return colour + " " + getMake();
    }
}