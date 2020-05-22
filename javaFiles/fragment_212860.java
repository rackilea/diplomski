private final AtomicBoolean executed = new AtomicBoolean();
...
// make sure that this is only executed once
if (!executed.compareAndSet(false, true)) {
    throw new IllegalStateException("Already executed.");
}