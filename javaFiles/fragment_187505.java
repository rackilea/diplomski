public interface Driveable {
  public Position accelerate(Vector v, Time t);
}

public interface Vehicle extends Driveable {
  public String getVehicleIdentificationNumber();
}

public class Boat implements Driveable { ... }
public class Car implements Vehicle { ... }