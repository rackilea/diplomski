class Car {
   RadioCar radioCar; //may be null or not 
   public Optional<RadioCar> getRadioCar() {
        return Optional.ofNullable(radioCar);
   }
}