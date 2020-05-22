String fileName = "cars.txt";
List<Car> cars = new ArrayList<>();
try (Scanner sc = new Scanner(new File("someFile.txt"))){
    int count = sc.nextInt();
    for (int i = 0; i < count; i++) {
        int year = sc.nextInt();
        String brand = sc.next();
        String type = sc.next();
        cars.add(new Car(year, brand, type));
    }
} catch (IOException e) {
    System.err.println("error reading cars from file "+fileName);
    e.printStackTrace();
}