public double sink;

@Benchmark
public void measureWrong_2() {
    // What could possibly go wrong?
    sink = Math.log(x);

    // Imagine this happens somewhere downstream.
    // Or, you are sinking in the loop.
    // Or, measureWrong_2 had inlined and the very next Math.log will sink.
    sink = Math.PI;
}