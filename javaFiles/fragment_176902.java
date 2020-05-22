public class Car {

  private int speed;

  public Car(int mph) {
    // this is an optional keyword.  I included it for clarity.
    this.speed = mph;
  }

  // This is the copy constructor
  public Car(Car other) {
    this.speed = other.speed;
  }

  public int getSpeed() {
    return speed;
  }

}