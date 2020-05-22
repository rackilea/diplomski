static List<Car> filterOutEverythingExceptSportCars(List<Car> cars) {
    List<Car> filteredCarsList = new ArrayList<>();
    for (Car car: cars) {
        if (!car.getCategory().contains("sport")) {
            filteredCarsList.add(car);
        }
    }
    return filteredCarsList;
}