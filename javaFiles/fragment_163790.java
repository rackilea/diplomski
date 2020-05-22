private static class MyDecodeP extends AbstractProcessor {
    private Object myStateObject;

    @Override
    protected boolean tryProcess(int ordinal, @Nonnull Object item) {
        Object mappedItem = ...;
        return tryEmit(mappedItem);
    }
}