static List<Function<? super Double, Double>> myList
    = Arrays.asList(d -> d + 4, d -> d * 2, d -> d - 3);

static Function<Double, Double> total=myList.stream()
    .map(f -> (Function<Double, Double>) d -> d + f.apply(d))
    .reduce(Function::andThen).orElse(Function.identity());

static double calculate(double val) {
    return total.apply(val);
}

public static void main(String[] args) {
    System.out.println(calculate(10));
}