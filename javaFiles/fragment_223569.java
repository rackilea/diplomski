package bench;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class MapSizeBench {
    @Param({"10", "100", "1000", "10000", "100000"})
    int size;

    Map<String, Double> map;

    @Setup
    public void setup() {
        map = IntStream.range(0, size).boxed().collect(Collectors.toMap(
                n -> "key" + n,
                n -> ThreadLocalRandom.current().nextDouble()));
    }

    @Benchmark
    public Map<String, Double> hashMap() {
        return new HashMap<>(map);
    }
}