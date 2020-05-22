public boolean isUsable() {
    return false;
}

public void use() {
    if (isUsable()) {
        throw new IllegalStateException("subclass must override use() if it's usable");
    }
    throw new UnsupportedOperationException("Not usable I told you");
}