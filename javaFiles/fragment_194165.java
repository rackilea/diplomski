private final AtomicBoolean fence = new AtomicBoolean();

public void readFence() {
    fence.get();
}

public void writeFence() {
    fence.set(true);
}