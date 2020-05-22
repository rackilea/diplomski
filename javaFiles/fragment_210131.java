class LoadCar extends Car implements LoadVehicle {
    // again, getters for these for the interface
    private int capacity, axes, rounds;
    // and constructor
    LoadCar(String brand, int year, int engNum, double price, 
        int cap, int axCount, int roundCount) {
        super(brand, year, engNum, price);
        // assigs the other parameters to variables
    }
}