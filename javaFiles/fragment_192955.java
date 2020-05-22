package tripcalculator;

public class TripCalculator {

    public static void main(String[] args) {
        Trip trip1 = new Trip();
        // trip1.getLitresUsed(); // No need in calling this method from outside.
        showTrip(trip1);
    }

    public static void showTrip(Trip trip1) {
        System.out.println(trip1.toString());
    }
}