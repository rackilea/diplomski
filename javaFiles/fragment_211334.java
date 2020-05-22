private final boolean usable;

protected Element(boolean usable) {
    this.usable = usable;
}

public final boolean isUsable() {
    return usable;
}

public final void use() {
    if (!isUsable()) {
        throw new UnsupportedOperationException("Not usable I told you");
    }
    doUse();
}

protected void doUse() {
    throw new IllegalStateException("subclass that can be usable must override doUse");
}