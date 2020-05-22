class Car extends Vehicle {
   public String type;
   public String model;


   public Car(int theCapacity, String theMake, String theType, String theModel) {
      super(theCapacity, theMake); // Here
      type = theType;
      model = theModel;
   }
}