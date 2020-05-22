public class RandomClass {
    private AtomicReference<Immutable> immutable = new AtomicReference(new Immutable.Builder(0).build());

    public Immutable getImmutable() {
        return immutable.get();
    }

    public boolean updateImmutable(Immutable oldValue, Immutable newValue) {
        return immutable.compareAndSet(oldValue, newValue);
    }
}