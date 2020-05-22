public class NamedCount<T> {

    private final T name;
    private final int count;

    public NamedCount(T name, int count) {
        this.name = name;
        this.count = count;
    }

    public T getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}