// Create a new car
Car car = new Car();
// Configures the car
car.setId(123);
car.setModel("Abc");
// Create a new spec
Spec spec = new Spec();
// Configures the spec
spec.setKilometers(123);
// Adds spec to the car's list
car.addSpec(spec);
// gets the first spec of the list
Spec firstSpec = car.getSpec(0);