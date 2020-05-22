public class FunkyMap extends HashMap<String, Object> {
    @SuppressWarnings("unchecked")
    public FunkyMap getNode(String key) {
        return (FunkyMap)get(key);
    }

    @SuppressWarnings("unchecked")
    public String getString(String key) {
        return (String)get(key);
    }

    @SuppressWarnings("unchecked")
    public Integer geInteger(String key) {
        return (Integer)get(key);
    }

    // you can add more methods for Date, Long, and any other types you know you'll get
}