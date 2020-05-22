package org.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;

public class StringsAppendBenchmark {
    private static String TESTING = "TESTING";

    @Benchmark
    @Fork(3)
    public void withVariable(Blackhole bh) {
        String s = "\n" + ">" + TESTING + "\n";
        bh.consume(s);
    }

    @Benchmark
    @Fork(3)
    public void withoutVariable(Blackhole bh) {
        bh.consume( "\n" + ">" + TESTING + "\n" );
    }
}