public abstract class BaseClass<T> {
    public abstract String start(String s1, String s2);

    public abstract String process(T value);

    protected final String log(String s) {
        // shared log implementation
    }
}