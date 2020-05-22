public class Contestant {
    private String name;
    private Map<String,Integer> timings = new HashMap<>();

    public Contestant(String name, Map<String, Integer> timings) {
        this.name = name;
        this.timings = timings;
    }

    public Integer getTimingFor(String activity) {
        return timings.get(activity);
    }

    public Map<String, Integer> getTimings() {
        return timings;
    }

    public String getName() {
        return name;
    }


}