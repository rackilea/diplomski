package bench;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class SwitchBench {
    @Param({"1", "2", "3", "4", "5", "6", "7", "8"})
    int n;

    @Benchmark
    public long lookupSwitch() {
        return Switch.lookupSwitch(n);
    }

    @Benchmark
    public long tableSwitch() {
        return Switch.tableSwitch(n);
    }
}