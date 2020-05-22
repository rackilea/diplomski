package bench;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class Listeners {
    List<Listener> listOfListeners = IntStream.range(0, 50)
            .mapToObj(Listener::new)
            .collect(Collectors.toList());

    Object[] arguments = {Math.random()};

    @Benchmark
    public void inside() {
        for (Listener listener : listOfListeners) {
            listener.apply(((Double) arguments[0]).longValue());
        }
    }

    @Benchmark
    public void outside() {
        long id = ((Double) arguments[0]).longValue();
        for (Listener listener : listOfListeners) {
            listener.apply(id);
        }
    }

    static class Listener {
        private long sum;

        Listener(int initialValue) {
            this.sum = initialValue;
        }

        public void apply(long id) {
            sum += id;
        }
    }
}