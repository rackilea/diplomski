import java.util.function.Function;

public class LambdaExpression {
    public static Function<Integer, Integer> create() {
        Function<Integer, Integer> f = x -> x + 1;    
        return f;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> f = create();
        System.out.println(f.apply(5)); // 6
    }
}