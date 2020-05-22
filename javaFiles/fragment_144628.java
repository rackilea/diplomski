public boolean saveIrr(@Nonnull TestObject test) { ... }

public void dontCareAboutNull(TestObject value) {
    saveIrr(value); // no bug
}

public void mightBeNull(@CheckForNull TestObject value) {
    saveIrr(value); // bug
}