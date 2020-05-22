public static void main(String[] args) {
    RegionMap map = new RegionMap();
    String region = "US";
    String s1 = "O";
    String s2 = "P";
    String val = map.search(region, s1, s2);
    System.out.println(val);
}

public class RegionMap {
    private Map<String, Map<String, Map<String, String>>> regionMap;

    public RegionMap() {
        init();
    }

    public String search(String region, String s1, String s2) {
        String val = searchS1(regionMap.get(region), s1, s2);
        if (val == null) {
            val = searchS1(regionMap.get("*"), s1, s2);
        }
        return val;
    }

    private String searchS1(Map<String, Map<String, String>> s1Map, String s1, String s2) {
        if (s1Map == null) {
            return null;
        }
        String val = searchS2(s1Map.get(s1), s2);
        if (val == null) {
            val = searchS2(s1Map.get("*"), s2);
        }
        return val;
    }

    private String searchS2(Map<String, String> s2Map, String s2) {
        if (s2Map == null) {
            return null;
        }
        String val = s2Map.get(s2);
        if (val == null) {
            val = s2Map.get("*");
        }
        return val;
    }

    private void init() {
        regionMap = new HashMap<>();
        addEntry("US", "A", "B", "1");
        addEntry("US", "A", "*", "2");
        addEntry("US", "*", "*", "3");
        addEntry("US", "O", "O", "4");
        addEntry("US", "*", "W", "5");
        addEntry("ASIA", "*", "*", "6");
    }

    private void addEntry(String region, String s1, String s2, String value) {
        Map<String, Map<String, String>> s1Map = regionMap.get(region);
        if (s1Map == null) {
            s1Map = new HashMap<>();
            regionMap.put(region, s1Map);
        }

        Map<String, String> s2Map = s1Map.get(s1);
        if (s2Map == null) {
            s2Map = new HashMap<>();
            s1Map.put(s1, s2Map);
        }

        s2Map.put(s2, value);
    }
}