public class User {
private Location locationLat;
private Location locationLon;

public User() {
  }
public User(Location locationLat, Location locationLon) {
    super();
    this.locationLat = locationLat;
    this.locationLon = locationLon;
  }
public Location getLocationLat() {
    return locationLat;
  }
public void setLocationLat(Location locationLat) {
    this.locationLat = locationLat;
  }
public Location getLocationLon() {
    return locationLon;
  }
public void setLocationLon(Location locationLon) {
    this.locationLon = locationLon;
  }
@Override
public String toString() {
    return "User [locationLat=" + locationLat + ", locationLon=" + locationLon + "]";
  } 
}