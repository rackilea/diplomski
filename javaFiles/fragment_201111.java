public class OsmResult implements Serializable{
    private double version;
    private String generator;
    private HashMap<String, String> osm3s;
    private ArrayList<Intersection> elements;

    ...getters & setters
}