package tripcalculator;

import java.util.Scanner;

public class Trip {
    Scanner kbd = new Scanner(System.in);
    private double distance; // This should be a double value
    final double MILEAGE = 0.14; // Let;s make constants private also. They are not needed for the world.
    final double COST_PER_LITRE = 1.29;

    // public void getLitresUsed() { // What was the purpose of this? Removed.
    //
    // }

    // constructor with distance parameter passed
    // public Trip(int distance) { // Actually, this constructor does not do
    // anything. Removed.
    // }

    // default constructor
    public Trip() {
        System.out.println("Enter distance travelled: ");
        distance = kbd.nextInt();
    }

    // getter and setter
    public double getDistance() {
        return distance;
    }

    // public void setDistance(int distance) { // We do not need setter method as
    // distance is being set when constructing Trip object.
    // this.distance = distance;
    // }

    public double getLitresUsed() { // distance is class variable. No need in method parameter distance. Removed.
        double litresUsed = MILEAGE * distance;
        return litresUsed;
    }

    public double getCost() { // litresUsed is being calculated by method. So, parameters has been removed and
                                // changed to method output.
        double cost = getLitresUsed() * COST_PER_LITRE;
        return cost;
    }

    @Override // Actually, we're overriding method here. Be careful.
    public String toString() {
        // getLitresUsed(); // These methods' outputs have been moved to String
        // generation.
        // getCost();
        String output = "Trip Details\n" + "\n" + "Distance: " + distance + " km\n" + "\n" + "Litres Used: "
                + getLitresUsed() + "\n" + "\n" + "Cost: $" + getCost();
        return output;
    }

}