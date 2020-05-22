public final boolean compareAndSet(V expectedValue, V newValue) {
    return VALUE.compareAndSet(this, expectedValue, newValue);
}

public final boolean weakCompareAndSet(V expectedValue, V newValue) {
    return VALUE.weakCompareAndSetPlain(this, expectedValue, newValue);
}