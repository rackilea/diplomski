private static class IdentityWrapper {

    public final Object ELEM;

    IdentityWrapper(Object elem) {
        this.ELEM = elem;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IdentityWrapper) && ELEM == ((IdentityWrapper) obj).ELEM;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(ELEM);
    }
}