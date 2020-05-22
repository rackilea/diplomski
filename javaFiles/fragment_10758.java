public class MapAndList {

    private List<String> keys = new ArrayList<String>();
    private Map<String, Object> keyValuePair = new HashMap<String, Object>();

    public void addItem(String key, Object item) {
        // TODO if the key is already present in the list throw exception
        keys.add(key);
        keyValuePair.put(key, item);
    }

    public void removeItem(String key) {
        keys.remove(key);
        keyValuePair.remove(key);
    }

    public void removteItem(int index) {
        removeItem(keys.get(index));
    }

    public void addItem(String key, Object item, int index) {
        keys.add(index, key);
        keyValuePair.put(key, item);
    }

}