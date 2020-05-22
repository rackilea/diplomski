class Honda extends Car {
  public static class CarItems extends Car.CarItems
  {

     public CarItems(Car.CarItems items) {
         this.property_1 = items.property_1;
         this.property_2 = items.property_2;
         this.property_3 = items.property_3;

         // etc.
     }

     @Override
     public void doStuff(){ ... }
  }
}