public class ImmutableBitSet extends BitSet {
    private final ImmutableBitSet delegate;

    public ImmutableBitSet(BitSet original) {
        or(original); // copy original to this
        delegate = this; // initialize a final reference for thread safety
    }

    @Override // example mutator method
    public void and(BitSet set) {
        throw new UnsupportedOperationException();
    }

    @Override // example non-mutator method
    public boolean get(int bitIndex) {
        return delegate.getPrivate(bitIndex);
    }

    // needed in order to avoid endless recursion
    private boolean getPrivate(int bitIndex) {
        super.get(bitIndex);
    }

    ...
}