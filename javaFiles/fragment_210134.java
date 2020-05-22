List<Vehicles> vehicles = new ArrayList<>();
List<Passenger> passengerVehicles = new ArrayList<>();
List<LoadCar> loadVehicles = new ArrayList<>();

// everything is a vehicle:
vehicles.add(luxuryCar); // fine
vehicles.add(compactCar); // fine
vehicles.add(truck); // fine
vehicles.add(wagon); // fine

// you can only add passenger vehicles the the passenger car list:
passengerVehicles.add(luxuryCar); // fine
passengerVehicles.add(compactCar); // fine
passengerVehicles.add(wagon); // fine
passengerVehicles.add(truck); // NO! a truck is not a passenger car.

// you can only add load cars to the load car list:
loadVehicles.add(luxuryCar); // NO! a PassengerCar is not a LoadCar.
loadVehicles.add(compactCar); // NO, same reason
loadVehicles.add(wagon); // fine
loadVehicles.add(truck); // fine