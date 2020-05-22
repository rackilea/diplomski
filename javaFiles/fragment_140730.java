HashMap<Car, Car> map = new HashMap<Car, Car>(...);
  for (Car car : carsToBeAggregated) {
      Car master = nap.get(car);
      if (master == null) {
          map.put(car, car);
      } else {
          master.offers.addAll(car.offers);
          // optionally, merge other Car information from car to master
      }
  }