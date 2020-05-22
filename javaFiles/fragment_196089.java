class HashCodeImpl implements HashCode {
    @Overwide
    public int getCode(Object obj) {
        return obj.hashCode();
    }
}