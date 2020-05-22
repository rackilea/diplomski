static Function<Integer, Integer> fibLambda = null;

public static void main(String[] args) {
    fibLambda = n -> n <= 2 ? 1 : Example.fibLambda.apply(n - 1) + Example.fibLambda.apply(n - 2);
    System.out.println(fibLambda.apply(6));
}