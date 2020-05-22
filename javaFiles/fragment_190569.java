public class Memoized<T> {
    private T value;
    // irrelevant parts omitted

    public T get() {
        T tempValue = value;

        if (tempValue == null) {
            // irrelevant parts omitted
        }

        return tempValue;
    }
}