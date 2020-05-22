private double i = Math.PI / 4 - 0.01;

@Benchmark
public double testMethod() {
    double res0 = Math.sin(i);
    double res1 = Math.sin(i);
    double res2 = Math.sin(i);
    return res0 + res1 + res2;
}