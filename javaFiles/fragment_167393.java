class RegisteredCar<T extends Car> implements Car {
   private final  T car

   RegisteredCar(T car) {
     this.car = car;
   }

   ... methods for RegisteredCar
   ... methods from Car delegating to `this.car`
}