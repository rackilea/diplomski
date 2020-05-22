public class DataClass {
    Map<String, Integer> data = new HashMap<>();

    public void addValueToData(String key) {
        if(!data.containsKey(key)) {
            data.put(key, 0);
        } else {
            data.put(key, data.get(key) + 1);
        }
    }
}