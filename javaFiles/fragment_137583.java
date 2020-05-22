//Builder Pattern
public class Airplane  {
    private final int[] seats;
    private final String name;
    private final int maxSpeed;
    private final int maxPassengers;

    public static class Builder {
        // Required parameters
        private final int[] seats;
        private final String name;

        // Optional parameters - initialized to default values
        private int maxSpeed = 1000;
        private int maxPassengers = 150;

        public Builder(int[] seats, String name) {
            this.seats = seats;
            this.name = name;
        }

        public Builder maxSpeed(int val) {
            maxSpeed = val;
            return this;
        }

        public Builder maxPassengers(int val) {
            maxPassengers = val;
            return this;
        }

        public Airplane build() {
            return new Airplane(this);
        }
    }

    private Airplane(Builder builder) {
        seats = builder.seats;
        name = builder.name;
        maxSpeed = builder.maxSpeed;
        maxPassengers = builder.maxPassengers;
    }
}