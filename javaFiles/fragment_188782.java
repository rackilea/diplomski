public void testCommuteSavings() {
  BikeCommute bike = new BikeCommute(...);
  CarCommute car = new CarCommute(...);
  SavingsCalculator calculator = new Calculator(car, bike);
  Assert.assertEquals(5, calcuator.getSavedGallons());
}