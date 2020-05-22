import java.util.stream.LongStream;

public class ParallelPlay {

    public static void main(String[] args) {
        System.out.println(parallelSum(100_000_000));
    }

    public static long parallelSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().sum();
    }
}