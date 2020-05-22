public class X {
    static Predicate<Number> IS_SYNTHETIC = p -> false;
    static Predicate<Number> IS_MLS_PROVIDER = p -> true;

    static void calcSynth(Stream<? extends Number> providers) {
        Stream<? extends Number> all =
            providers.filter(Predicates.and(IS_MLS_PROVIDER,
                                            Predicates.not(IS_SYNTHETIC)));
    }
}

class Predicates {
    static <T> Predicate<T> and(Predicate<? super T> p1, Predicate<? super T> p2) {
        return x -> p1.test(x) && p2.test(x);
    }

    static <T> Predicate<T> not(Predicate<T> p) {
        return x -> !p.test(x);
    }
}