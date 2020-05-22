private final AtomicReference<Integer> hashcode = new AtomicReference<>();

@Override
public int hashCode() {
    Integer h = hashcode.get();
    if (h != null) return h;
    int computedHash = Arrays.hashCode(array);
    hashcode.compareAndSet(null, computedHash);
    return computedHash;
}