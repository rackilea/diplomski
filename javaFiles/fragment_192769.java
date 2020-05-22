String fileName =
            "C:\\Users\\beng\\eclipse-workspace\\Assignment Trailblazer\\Car Data";
Path path = Paths.get(fileName);
List<String> lines = Files.readAllLines(path); // Without line ending.

List<Car> cars = new ArrayList<>();
for (String line : lines) {
    String[] data = line.split(",");
    Car car = new Car(data);
    cars.add(car);
}