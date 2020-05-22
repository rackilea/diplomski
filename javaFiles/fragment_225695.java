public class CountedClass {
    private static final AtomicInteger counter = new AtomicInteger();

    public CountedClass() {
        counter.incrementAndGet();
    }

    public static int getInstanceCount() {
        return counter.get();
    }
}