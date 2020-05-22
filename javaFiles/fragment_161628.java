public class Predicates {
    public static <T,R> Predicate<T> andThenTest(
            Function<T,R> func, Predicate<R> pred) {
        return t -> pred.test(func.apply(t));
    }
}