import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Accumulator {
    public static LongStream toCumulativeSumStream(IntStream ints){
        AtomicLong sum = new AtomicLong(0);
        return ints.sequential().mapToLong(sum::addAndGet);
    }

    public static void main(String[] args){
        LongStream sums = Accumulator.toCumulativeSumStream(IntStream.range(1, 5));
        sums.forEachOrdered(System.out::println);
    }
}