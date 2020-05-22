public class Tuple2<T,U>{
    private final T first;
    private final U second;

    public Tuple2(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }
}