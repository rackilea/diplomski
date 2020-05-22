interface F<T,R> {
    R apply(T t);
}
interface AF<T,R> {
    Future<R> apply(T t);
}
static <T,R> Future<R> method(F<T,R> f) {
    return null;
}
static <T,R> Future<R> method(AF<T,R> f) {
    return null;
}
public static void main(String[] args) {
    // these two don't compile
    method(x -> "bla");
    method(x -> new FutureTask<String>(null));

    // these two do compile
    method((Object x) -> "bla");
    method((Object x) -> new FutureTask<String>(null));
}