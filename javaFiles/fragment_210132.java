class Wagon extends LoadCar implements Passengers {
    // again, getter and setter for this for the interface
    private int passengers;
    Wagon(String brand, int year, int engNum, double price, 
        int cap, int axCount, int roundCount) {
        super(brand, year, engNum, price, cap, axCount, roundCount);
}