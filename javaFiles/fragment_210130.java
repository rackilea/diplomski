class PassengerCar extends Car implements Passengers {
    // add getter and setter for this to implement the interface
    private int passengers;
    PassengerCar(String brand, int year, int engNum, double price) {
        super(brand, year, engNum, price);
    }
}