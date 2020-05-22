import java.util.function.*;

class Test {
    public static void main(String[] args) {
        Function<String, Integer> function = asFunction(String::length).andThen(n -> n * 2);
        System.out.println(function.apply("foo"));
    }

    public static <T1, T2> Function<T1, T2> asFunction(Function<T1, T2> function) {
        return function;     
    }
}