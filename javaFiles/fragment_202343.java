public final void lazySet(V newValue) {
    unsafe.putOrderedObject(this, valueOffset, newValue);
}

public final boolean compareAndSet(V expect, V update) {
    return unsafe.compareAndSwapObject(this, valueOffset, expect, update);
}