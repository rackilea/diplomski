public class Locatie {
  private static final double DOORSNEDE_AARDE = 40000.0;
  public final double latitude;
  public final double longitude;

  public Locatie(double latitude, double longitude) throws IllegalArgumentException {
  if (latitude > 90 || latitude < -90) {
      throw new IllegalArgumentException("latitude moet tussen - 90 en 90 liggen, was "
              + latitude);
  }
  if (longitude < -360 || longitude > 360) {
      throw new IllegalArgumentException("Longitude moet tussen -360 en 360 liggen was "
              + longitude);
  }
  this.latitude = latitude;
  this.longitude = longitude;