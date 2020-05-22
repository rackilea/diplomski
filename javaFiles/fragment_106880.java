import java.util.*;

public class AllMyData {
    private Map<String, List<MyData>> map;

    public AllMyData() {
        map = new HashMap<String, List<MyData>>();

        map.put("cli", new ArrayList<>());
        map.put("sub", new ArrayList<>());
        map.put("emp", new ArrayList<>());
        map.put("exp", new ArrayList<>());
        map.put("oex", new ArrayList<>());
        map.put("bin", new ArrayList<>());
        map.put("ven", new ArrayList<>());
    }

    public void add(String key, List<MyData> data) {
        List<MyData> list = get(key);
        if (list == null) {
            map.put(key, data);
        } else {
            list.addAll(data);
            map.put(key, list);
        }
    }

    public void add(String key, MyData data) {
        List<MyData> list = get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(data);
        map.put(key, list);
    }

    public List<MyData> get(String key) {
        return map.get(key);
    }

    @Override
    public String toString() {
        return String.format("AllMyData [map=%s]", map);
    }
}