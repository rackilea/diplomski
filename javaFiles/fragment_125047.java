package org.sample;

import java.text.NumberFormat;
import java.text.DecimalFormat;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;

@State(Scope.Thread)
public class TestStringSplit {

    // This state class lets us set up our list once and reuse it for tests in this test thread
    @State(Scope.Thread)
    public static class TestState {
        public final StringBuffer sb;

        public TestState() {
            NumberFormat formatter = new DecimalFormat("#0.00000");

            StringBuffer b = new StringBuffer();        

            for (int i = 0; i < Common.LENGTH; ++i)
            {
                b.append("String:" + i + " ");
            }

            this.sb = b;
        }
    }

    // This is the test method JHM will run for us
    @Benchmark
    public void test(TestState state) {
        // Grab the StringBuffer, convert to string, split it into an array
        final String[] strings = state.sb.toString().split(" ");

        // Loop through it -- note that I'm doing work within the loop, but not I/O since
        // we don't want to measure I/O, we want to measure loop performance
        int l = 0;
        for (String s : strings) {
            l += s == null ? 0 : 1;
        }

        // I always do things like this to ensure that the test is doing what I expected
        // it to do, and so that I actually use the result of the work from the loop
        if (l != Common.LENGTH) {
            throw new RuntimeException("Test error");
        }
    }
}