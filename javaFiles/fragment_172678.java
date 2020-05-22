public static void main(String[] args) {
    Bike bike1 = new Bike(); // Creating the first Bike instance
    bike1.setModel("This Is Valid"); // Valid model
    bike1.setYear(10); // Valid year
    bike1.setType("cross-country"); // Valid type

    Bike bike2 = new Bike(); // Creating the second Bike instance
    bike2.setModel("This-Is-Invalid"); // Invalid model
    bike2.setYear(-1); // Invalid year
    bike2.setType("Invalid Type"); // Invalid type

    bike1.display(); // Expected Year:10 Model:This Is Valid Type:cross-country
    bike2.display(); // Expected Year:0 Model:ThisIsInvalid Type:null
}