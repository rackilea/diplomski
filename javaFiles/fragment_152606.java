public class MaxMemoryProfiler implements InternalProfiler {

    @Override
    public String getDescription() {
        return "Max memory heap profiler";
    }

    @Override
    public void beforeIteration(BenchmarkParams benchmarkParams, IterationParams iterationParams) {

    }

    @Override
    public Collection<? extends Result> afterIteration(BenchmarkParams benchmarkParams, IterationParams iterationParams,
        IterationResult result) {

        long totalHeap = Runtime.getRuntime().totalMemory(); // Here the value
                                                         // you want to
                                                         // collect

        Collection<ScalarResult> results = new ArrayList<>();
        results.add(new ScalarResult("Max memory heap", totalHeap, "bytes", AggregationPolicy.MAX));

        return results;
    }
}