public class Test {
    private final Map<String, String> map = new ConcurrentHashMap<>();

    public void resetMap() { map.clear(); }

    public Map<String, String> getMap() { return map; }
}