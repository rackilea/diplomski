public final class UnorderedPair<T> {
    public final T a, b;

    public UnorderedPair(T a, T b) {
        this.a = a;
        this.b = b;
    }
    public int hashCode() {
        return a.hashCode()+b.hashCode()+UnorderedPair.class.hashCode();
    }
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof UnorderedPair)) return false;
        final UnorderedPair<?> other = (UnorderedPair<?>) obj;
        return a.equals(other.a) && b.equals(other.b)
            || a.equals(other.b) && b.equals(other.a);
    }
}