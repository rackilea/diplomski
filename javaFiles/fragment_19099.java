while (scanner.hasNext()) {
  String line = scanner.nextLine();
  String[] parts = line.split(" ");
  String regNo = parts[0];
  String make = parts[1];
  int year = Integer.parseInt(parts[2]);
  String description = parts[3];

  if (parts.length == 5) {
    double height = scanner.nextDouble();
    vehicle = new OversizedVehicle(regNo, make, year, description, height);
  } else {
    vehicle = new Vehicle(regNo, make, year, description);
  }

  // ...
}