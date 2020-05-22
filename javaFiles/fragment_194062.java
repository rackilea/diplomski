import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.*;

// 5 warm-up iterations, 500 ms each, then 10 measurement iterations 500 ms each
// repeat everything three times (with JVM restart)
// output average time in microseconds
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(3)
@State(Scope.Benchmark)
public class ListTest {
    // You did not supply Node and LinkedList implementation
    // but I assume they look like this
    static class Node<T> {
        final T value;
        Node<T> next;

        public Node(T val) {value = val;}
        public void add(Node<T> n) {next = n;}

        public Node<T> getNext() {return next;}
    }

    static class LinkedList<T> {
        Node<T> head;

        public void setHead(Node<T> h) {head = h;}
        public Node<T> getHead() {return head;}
    }

    // Code from your question follows

    // 1. iterative approach
    public static <T> int getLengthIteratively(LinkedList<T> ll) {

        int length = 0;
        for (Node<T> ptr = ll.getHead(); ptr != null; ptr = ptr.getNext()) {
            length++;
        }

        return length;
    }

    // 2. recursive approach
    public static <T> int getLengthRecursively(LinkedList<T> ll) {
        return getLengthRecursively(ll.getHead());
    }

    private static <T> int getLengthRecursively(Node<T> ptr) {

        if (ptr == null) {
            return 0;
        } else {
            return 1 + getLengthRecursively(ptr.getNext());
        }
    }

    // 3. Pseudo tail-recursive approach
    public static <T> int getLengthWithFakeTailRecursion(LinkedList<T> ll) {
        return getLengthWithFakeTailRecursion(ll.getHead());
    }

    private static <T> int getLengthWithFakeTailRecursion(Node<T> ptr) {
        return getLengthWithFakeTailRecursion(ptr, 0);
    }

    private static <T> int getLengthWithFakeTailRecursion(Node<T> ptr, int result) {
        if (ptr == null) {
            return result;
        } else {
            return getLengthWithFakeTailRecursion(ptr.getNext(), result + 1);
        }
    }

    // Benchmarking code

    // Measure for different list length        
    @Param({"10", "100", "1000", "10000"})
    int n;
    LinkedList<Integer> list;

    @Setup    
    public void setup() {
        list = new LinkedList<>();
        Node<Integer> cur = new Node<>(0);
        list.setHead(cur);
        for(int i=1; i<n; i++) {
            Node<Integer> next = new Node<>(i);
            cur.add(next);
            cur = next;
        }
    }

    // Do not forget to return result to the caller, so it's not optimized out
    @Benchmark    
    public int testIteratively() {
        return getLengthIteratively(list);
    }

    @Benchmark    
    public int testRecursively() {
        return getLengthRecursively(list);
    }

    @Benchmark    
    public int testRecursivelyFakeTail() {
        return getLengthWithFakeTailRecursion(list);
    }
}