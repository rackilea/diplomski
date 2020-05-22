@Benchmark
public void measureRight_2(Blackhole bh) {
    bh.consume(Math.log(x1));
    bh.consume(Math.log(x2));
}

public double sink;

@Benchmark
public void measureWrong_2() {
    sink = Math.log(x1);
    sink = Math.log(x2);
}