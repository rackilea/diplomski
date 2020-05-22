public class EnclosingClass {
  public static abstract class LocationResult{
    public abstract void gotLocation(Location location);
  }
}

EnclosingClass.LocationResult locationResult = ...