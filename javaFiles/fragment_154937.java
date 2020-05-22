public Customer(String name, Car car) {
    this.name = name;
    this.car = car;
}

// and
public Customer(String name, String brand, String model) {
    this.name = name;
    this.car = new Car(brand, model);
}