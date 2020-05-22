import java.util.function.Function;

public class LambdaExpression {
    public static Function<Integer, Integer> create(int addTo) {
        Function<Integer, Integer> f = x -> x + addTo;
        return f;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> f = create(3);
        System.out.println(f.apply(5)); // 8
    }
}