public class MyCaseInsensitiveMap extends HashMap<String, String> {
    ...
    put(String key, String value) {
       super.put(key.toLowerCase(), value);
    }

    get(String key) {
       super.get(key.toLowercase());
    }
}