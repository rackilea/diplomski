Function<Number, Number> f1 = x -> x.doubleValue() * 2;
Function<Double, Double> f2 = x -> x.doubleValue() * 3;

Number myApplyThen = (input) -> {
    Number y1 = f1.apply(input);
    Double y2 = f2.apply(y1);    // ERROR: f2 requires a Double!
};