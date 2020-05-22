Map<Integer, CarShop> result = someListOfCars.stream().collect(
        HashMap::new,
        (map, car) -> car.getCarProducts().forEach(
                prod -> map.put(prod.getId(), car.getCarShop())
        ),
        Map::putAll
);