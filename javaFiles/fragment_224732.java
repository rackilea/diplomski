abstract static class Builder<T extends Data, B extends Builder<T, B>> {

    private String one;

    protected Builder() {
        this.one = null;
    }

    public final B withOne(final String value) {
        this.one = value;
        return (B) this;
    }

    protected abstract T build();
}