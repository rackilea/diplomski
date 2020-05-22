List<Car> filteredCars =
    cars.stream()
        .filter (
            car -> wheels.stream()
                         .anyMatch(wheel -> wheel.getColor() == car.getColor() &&      
                                            wheel.isWorking()))
        .collect(Collectors.toList());