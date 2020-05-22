public void benchmarkReturnOrdinal_thrpt_jmhStub(InfraControl control, RawResults result, ReturnEnumObjectVersusPrimitiveBenchmark_jmh l_returnenumobjectversusprimitivebenchmark0_0, Blackhole_jmh l_blackhole1_1) throws Throwable {
    long operations = 0;
    long realTime = 0;
    result.startTime = System.nanoTime();
    do {
        l_blackhole1_1.consume(l_longname.benchmarkReturnOrdinal());
        operations++;
    } while(!control.isDone);
    result.stopTime = System.nanoTime();
    result.realTime = realTime;
    result.measuredOps = operations;
}