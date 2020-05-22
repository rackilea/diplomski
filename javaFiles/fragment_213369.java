interface Person<T extends Vehicle> {
    public ArrayList<T> getVehicles();
    public void setVehicles (ArrayList<T> vs);
}

class CarOwner implements Person<Car> {
    public ArrayList<Car> cars;
    public ArrayList<Car> getVehicles() {
        return cars;
    }
    public void setVehicles(ArrayList<Car> cars) {
        this.cars = cars;
    }
}