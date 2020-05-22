public class A {
    private static final A INSTANCE = new A();
    private LinkedHashMap<Integer, String> map;
    private final Object locker = new Object();
    private A() {}

    public static A getInstance() {
        return INSTANCE; // Look how simple this got!
    }

    public Map<Integer, String> getMap() {
        synchronized (locker) {
            if (map == null) refresh();
            return map;
        }
    }

    public void refresh() {
        synchronized (locker) {
            // refresh map here...
            map = ....;
        }
    }
}