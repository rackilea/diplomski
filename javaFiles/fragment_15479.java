public class ResultOsrm
{
    public List<Waypoint> waypoints;
}

public class Waypoint
{
    public int waypoint_index;
    public int trips_index;
    public String hint;
    public String name;
    public List<float> location;
}