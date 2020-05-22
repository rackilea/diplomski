public class Boat { ... }
public class Car { ... }

public CarFactory implements Task<Car> {
  public Boat execute() { ... } // Error! A Boat is not a Car.
}