// This is a helper class
class MetroNode {
  public String station;
  public GeoPoint point; 

  public MetroNode (String station, GeoPoint point) {
    this.station = station;
    this.point = point;
  }
}

// This is the module's main class
public class MainScreen extends MapActivity {

  // This is public and private data for each class instance
  private LinkedList<MetroNode> station_location = null;

  // This is the activity's initialization
  public void onCreate(Bundle savedInstanceState) 
    station_locations = new LinkedList<MetroNode>();
    MetroNode metroNode = new MetroNode ("anand_nagar", new GeoPoint (1.00, 2.00));
    station_locations.add (metroNode);
  ...