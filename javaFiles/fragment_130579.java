public abstract static class MemoizedHashCodeList<K> implements List<K>{
    private final long hashCode;
    private final List<K> delegate;
    public MemoizedHashCodeList(List<K> delegate) {
        this.delegate = delegate;
        hashCode = delegate.hashCode();
    }

    /* Rest of the List<K> implementation */
}