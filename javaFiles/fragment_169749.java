public class MyMapProvider implements Provider<Map<String,List<String>> {
    private Map<String,List<String>> myMap = new HashMap<>();

    public Map<String,List<String>> get() {
        return myMap;
    }
}