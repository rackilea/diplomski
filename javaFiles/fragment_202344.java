public final void lazySet(V newValue) {
    VALUE.setRelease(this, newValue);
}

public final boolean compareAndSet(V expectedValue, V newValue) {
    return VALUE.compareAndSet(this, expectedValue, newValue);
}