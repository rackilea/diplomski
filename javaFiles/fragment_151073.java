import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ThreadLocalRandom;

@State(Scope.Benchmark)
public class ReturnPair {
    int counter;

    @Benchmark
    public void manualInline(Blackhole bh) {
        bh.consume(counter++);
        bh.consume(ThreadLocalRandom.current().nextInt());
    }

    @Benchmark
    public void packToLong(Blackhole bh) {
        long packed = getPacked();
        bh.consume((int) (packed >>> 32));
        bh.consume((int) packed);
    }

    @Benchmark
    public void pairObject(Blackhole bh) {
        Pair pair = getPair();
        bh.consume(pair.a);
        bh.consume(pair.b);
    }

    @Benchmark
    @Fork(jvmArgs = "-XX:-EliminateAllocations")
    public void pairObjectAllocated(Blackhole bh) {
        Pair pair = getPair();
        bh.consume(pair.a);
        bh.consume(pair.b);
    }

    public long getPacked() {
        int a = counter++;
        int b = ThreadLocalRandom.current().nextInt();
        return (long) a << 32 | (b & 0xffffffffL);
    }

    public Pair getPair() {
        int a = counter++;
        int b = ThreadLocalRandom.current().nextInt();
        return new Pair(a, b);
    }

    static class Pair {
        final int a;
        final int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}