import java.util.function.Function;

public class Example {
    public static <T, U, R> Function<T, Function<U, R>> curry(BiFunction<T, U, R> f) {
        return t -> u -> f.apply(t, u);
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> curriedAdd = curry(Example::add);
        // or
        // BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        // curriedAdd = curry(add);

        Function<Integer, Integer> increment = curriedAdd.apply(1);
        System.out.println(increment.apply(4));
    }
}