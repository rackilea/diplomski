public class A {
    private static Map<String, String> map;

    /** must be invoked before get is first called */
    public static void init(Map<String, String> newmap) {
        map = newmap;
    }

    public static String get(String key) {
        return map.get(key);
    }
}