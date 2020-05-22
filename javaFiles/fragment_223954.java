final Predicate<Car> expensiveCar = new Predicate<Car>() {
   public boolean apply(Car car) {
      return car.price > 50000;
   }
}

List<Car> cars = Lists.newArrayList();
cars.add(new Car("Ford Taurus", 20000));
cars.add(new Car("Tesla", 90000));
cars.add(new Car("Toyota Camry", 25000));
cars.add(new Car("McClaren F1", 600000));

final List<Car> premiumCars =
   Lists.immutableList(Iterables.filter(cars, expensiveCar));