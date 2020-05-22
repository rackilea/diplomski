String fileName =
            "C:\\Users\\beng\\eclipse-workspace\\Assignment Trailblazer\\Car Data";
Path path = Paths.get(fileName);
List<Car> cars = Files.lines(path)     // Stream<String>
    .map(line -> line.split(","))      // Stream<String[]>
    .map(Car::new)                     // Stream<Car>
    .collect(Collectors.toList());     // List<Car>