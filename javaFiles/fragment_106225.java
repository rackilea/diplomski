import java.util.function.*;

class Test {
    public static void main(String[] args) {
        Function<String, Integer> function = combine(String::length, n -> n * 2);
        System.out.println(function.apply("foo"));
    }

    public static <T1, T2, T3> Function<T1, T3> combine(
        Function<T1, T2> first,
        Function<T2, T3> second) {
        return first.andThen(second);
    }
}