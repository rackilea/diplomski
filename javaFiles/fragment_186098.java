public class Stops {

    public Map<String, String[]> arrivalTime = new HashMap<>();
    public String stopsName;

    @JsonCreator
    public Stops(@JsonProperty("arrival_time") Map<String, String[]> arrivalTime,
                 @JsonProperty("stop_name") String stopsName) {
        this.arrivalTime = arrivalTime;
        this.stopsName = stopsName;
    }
}

public class Root {

    public List<Stops> stops = new ArrayList<Stops>();
    public String route;
    private String direction;

    @JsonCreator
    public Root(@JsonProperty("stops") List<Stops> stops,
                @JsonProperty("route") String route,
                @JsonProperty("direction") String direction) {
        this.stops = stops;
        this.route = route;
        this.direction = direction;
    }
}

public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    String is = "[{\"stops\":[{\"arrival_time\":{\"sat\":[\"04:41\",\"05:41\",\"06:09\"],\"mon-fri\":[\"04:24\",\"05:10\",\"05:40\"],\"sun\":[\"07:20\",\"08:20\",\"09:20\"]},\"stop_name\":\"Ravensbusch \"}],\"route\":\"2\",\"direction\":\"Bornkamp\"}]";
    List<Root> roots = mapper.readValue(is, TypeFactory.defaultInstance()
            .constructCollectionType(List.class, Root.class));
    // Rest of your code here
}