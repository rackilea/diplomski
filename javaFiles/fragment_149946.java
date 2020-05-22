public static String fetchCarModel(String value2A) {    
    final Optional<CarModel> carModel =  Car.api().models().list().stream()
            .filter(carModel -> carModel.getKey2().equals(value2A)) // Check for the correct object
            .findAny();   

    return carModel.get().getKey3(); // get the value of this property
}