public class CompletedScheduledFuture<T> implements ScheduledFuture<T> {
    private T value;

    public CompletedScheduledFuture(T value) {
        this.value = value;
    }

    public T get() { return value; }
    public T get(long timeout, TimeUnit unit) { return value; }
    public boolean cancel() { return false; }
    public boolean isDone() { return true; }
    public boolean isCancelled() { return false; }
    public long getDelay(TimeUnit unit) { return 0; }

    public int compareTo(Delayed other) {
        Long.compare(getDelay(NANOSECONDS), 
                     other.getDelay(NANOSECONDS));
    }
}