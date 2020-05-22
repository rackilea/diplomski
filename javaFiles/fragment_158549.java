public class MinMaxBenchmark {

    @State(Scope.Benchmark)
    public static class MyState {

        int arraySize = 50_0000;
        int[] elements = new int[arraySize];

        @Setup(Level.Trial)
        public void doSetup() {
            List<Integer> list = new ArrayList<>(arraySize);
            for (int k = 0; k < arraySize; k++) {
                list.add(k);
            }
            Collections.sort(list);
            Integer[] integers = list.toArray(new Integer[0]);
            for (int k = 0; k < arraySize; k++) {
                elements[k] = integers[k];
            }

        }
    }


    @Benchmark @BenchmarkMode(Mode.SampleTime   ) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public Pair classic(MyState state) {
        return classicMinMax(state.elements);
    }
    @Benchmark @BenchmarkMode(Mode.SampleTime) @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public Pair divide(MyState state) {
        return divideAndConquer(state.elements);
    }

}