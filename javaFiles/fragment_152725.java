static final AverageMaker<Double> doubleAvg = new AverageMaker<Double>() {
    public Double initialResult() { return 0.0; }
    public Double add(Double a, Number b) { return a + b.doubleValue(); }
    public Double divideByCount(Double a, int b) { return a/b; }
};
static final AverageMaker<Integer> intAvg = new AverageMaker<Integer>() {
    public Integer initialResult() { return 0; }
    public Integer add(Integer a, Number b) { return a + b.intValue(); }
    public Integer divideByCount(Integer a, int b) { return a/b; }
};