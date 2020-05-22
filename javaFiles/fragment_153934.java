public static class MethodHolder{
    private String property;
    private Method getMethod;
    private Method setMethod;

    public MethodHolder() {
    }

    public MethodHolder(String property, Method getMethod, Method setMethod) {
        this.property = property;
        this.getMethod = getMethod;
        this.setMethod = setMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MethodHolder)) return false;
        MethodHolder that = (MethodHolder) o;
        return Objects.equals(property, that.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property);
    }
}