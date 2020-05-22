class Location {
    private double _lat;
    private double _long;

    public Location(double lat, double long) { _lat = lat; _long = long }

    public static Location fromJSONArray(JSONArray json) {
        int n = json.length();
        if(n != 2) throw new IllegalArgumentException('json');

        return new Location(json.getDouble(0), json.getDouble(1));
    }
}
class Polygon : List<Location> {
    public static Polygon fromJSONArray(JSONArray json) {
        int n = json.length();
        Polygon p = new Polygon();
        for(int i = 0; i < n; i++) {
            p.add(Location.fromJSONArray(json.getJSONArray(i)));
        }
        return polygon;
    }
}

private List<Polygon> parseLists(JSONArray nestedList) throws JSONException
{
    List<Polygon> polygons = new ArrayList<Polygon>();
    int n = json.length();
    for(int i = 0; i < n; i++) {
        polygons.add(Polygon.fromJSONArray(json.getJSONArray(i)));
    }
    return polygons;
}