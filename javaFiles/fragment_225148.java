public static void main(String[] args) {
    Person john = new Person("John");
    Vehicle vehicle = new Car(john);

    doGet(vehicle);
}

public static void doGet(Vehicle vehicle) {
    Person p = vehicle.getDriver();
    System.out.println(p); 
}