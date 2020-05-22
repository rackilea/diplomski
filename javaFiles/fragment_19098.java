while (scanner.hasNext()) {
  String regNo = scanner.next();
  String make = scanner.next();
  int year = scanner.nextInt();
  String description = scanner.next();

  if (scanner.hasNext() && !scanner.hasNextInt()) {
    double height = scanner.nextDouble();
    vehicle = new OversizedVehicle(regNo, make, year, description, height);
  } else {
    vehicle = new Vehicle(regNo, make, year, description);
  }

  // ...
}