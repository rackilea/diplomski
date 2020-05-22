public class Tuple<A,B> {
    public final A _1;
    public final B _2;
    public Tuple(A a, B b){
        _1 = a;
        _2 = b;
    }
    public static <A,B> Tuple<A,B> tuple(A a, B b){
        return new Tuple<>(a, b);
    }
}