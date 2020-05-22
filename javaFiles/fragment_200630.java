public class XmlObject {
    final String type; 
    Map<String, ObjectWrapper> map = new Map<>();

    public XmlObject(String type) {
        this.type = type;
    }

    public void put(String key, ObjectWrapper object) {
        map.add(key, object);
    }

    public ObjectWrapper get(String key) {
        return map.get(key);
    }
}