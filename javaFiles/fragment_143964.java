final class SortKey {
    final String field;
    final Direction direction;
    private SortKey(String f, Direction d) { field=f; direction=d; }
    @Override
    public int hashCode() {
        return field.hashCode()*2+direction.ordinal();
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof SortKey)) return false;
        SortKey that = (SortKey)obj;
        return this.direction == that.direction && this.field.equals(that.field);
    }
    static SortKey of(String field, Direction dir) {
        return new SortKey(Objects.requireNonNull(field), Objects.requireNonNull(dir));
    }
    static SortKey of(ISort s) {
        return of(s.getField(), s.getSort());
    }
}