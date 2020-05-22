public class ThreadCounter {
    public static final AtomicInteger threadCounter = new AtomicInteger(N);
    public static final AtomicInteger queueCounter = new AtomicInteger(0);
    public static final Object poisonPill = new Object();
    public static volatile boolean cancel = false; // or use a final AomticBoolean instead
}