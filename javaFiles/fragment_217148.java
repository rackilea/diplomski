public static void main(String[] args) {

    Car car = new Car();
    car.populate();
    car.addModel("AnotherBrand", new HashSet<>(Arrays.asList("a", "b")));
    System.out.println(car.getCarMap());

}