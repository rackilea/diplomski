public class YourClass {
  public ReturnType yourMethod() {
    car.driveCar("carName", getBrand());
  }

  /** Gets brand via problematicMethod(). Package private for test overrides. */
  Brand getBrand() {
    return problematicMethod().getBrand();
  }
}