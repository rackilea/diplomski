public class RandomClass {
    private final Object monitor = new Object();
    @GuardedBy("monitor")
    private Immutable immutable = new Immutable.Builder(0).build();

    public Immutable getImmutable() {
        synchronized (monitor) {
            return immutable;
        }
    }

    public void updateImmutable(Function<Immutable, Immutable> mutator) {
        synchronized (monitor) {
            immutable = mutator.apply(immutable);
        }
    }
}