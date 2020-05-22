abstract static class Builder<T extends Data, B extends Builder<T, B>> {

    private String one;

    protected Builder() {
        this.one = null;
    }

    protected abstract B getThis();

    public final B withOne(final String value) {
        this.one = value;
        return getThis(); // no need to cast now
    }

    protected abstract T build();
}