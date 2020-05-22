public List<Car> findUpdatedCars(Collection<Car> oldCars, Collection<Car> newCars)
  List<Car> updatedCars = new ArrayList<Car>();
  Iterator oldIt = oldCars.iterator();
  for (Car newCar:newCars) {
    if (!newCar.equals(oldIt.next()) {
      updatedCars.add(newCar);
    }
  }
  return updatedCars;
}