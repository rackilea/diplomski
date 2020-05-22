public class MyObject extends HashMap<String, Object> {
    @Override   
    public Object put(String key, Object value) {
        System.out.println("Key: " + key + " Value: " + value + " Class: " + value.getClass());
        return super.put(key, value);
    }
}