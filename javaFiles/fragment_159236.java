Pipeline p = ...;
 p.apply("create1", Create.of("hello")).apply("myStepName1", ParDo.of(new SomeDoFn()));
 p.apply("create2", Create.of("world")).apply("myStepName2", ParDo.of(new SomeDoFn()));
 PipelineResult result = p.run();
 MetricResults metrics = result.metrics();
 MetricQueryResults metricResults = metrics.queryMetrics(new MetricsFilter.Builder()
     .addNameFilter("my-counter")
     .addStepFilter("myStepName1").addStepFilter("myStepName2")
     .build());
 Iterable<MetricResult<Long>> counters = metricResults.counters();
 // counters should contain the value of my-counter reported from each of the ParDo
 // applications.