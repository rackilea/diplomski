public class Manager<T> {
    private final Map<String, T> objects;

    public Manager() {
        objects = new HashMap<String, T>();
    }
}