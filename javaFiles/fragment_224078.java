Car updateCar = new Car(2, "Fiat", (float)35000); // unnecessary object construction
    Car newCar =  cars.stream()
      .filter(c -> c.getId().equals(updateCar.getId()))
      .collect(toList()) // unnecessary List creation
      .get(0); // just to get the first element
    newCar.setPrice(updateCar.getPrice()); // to perform an action on it