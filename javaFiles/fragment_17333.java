public class Holder {

    private Map<String, Object> objects = new HashMap<String, Object>();

    public void add(String key, Object value) {
        objects.put(key, value);
    }

    public Map<String, Object> getObjectsMap() {
        return objects;
    }

}