import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 20, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 20, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class TestArraylist {

    @Benchmark
    public String Arraylistpart() {
        ArrayList<Object> a1 = new ArrayList<>();
        ArrayList<Object> a2 = new ArrayList<>();
        a2 = a1;

        a1.add(1);
        a1.add('c');
        a1.add("gh");
        a1.add(2);
        a1.set(2, "ab");
        int count = 0;
        for (Object i : a1) {
            a2.set(count, i.toString());
            count = count + 1;
        }
        a2.sort(null);
        return a1.toString()+a2.toString();
    }

    @Benchmark
    public String vectorpart() {
        Vector<Object> v1 = new Vector<>();
        Vector<Object> v2 = new Vector<>();
        v2 = v1;
        v1.add(1);
        v1.add('c');
        v1.add("ab");
        v1.add(2);
        int count1 = 0;
        for (Object i : v1) {
            v2.setElementAt(i.toString(), count1);
            count1 = count1 + 1;
        }
        v2.sort(null);
        return v1.toString()+v2.toString();
    }
}