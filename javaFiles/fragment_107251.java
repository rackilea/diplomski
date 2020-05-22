class OperateAll<T> implements B<B<T>> {
    private Collection<T> collection;

    public OperateAll(Collection<T> collection) {
        this.collection = collection;
    }

    public boolean operate(B<T> t) {
        if (t == null) {
            return false;
        }

        for (T item : collection) {
            if (!t.operate(item)) return false;
        }
        return true;
    }
}