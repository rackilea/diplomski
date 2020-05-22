public static class ClassList {

    private int size;
    private int newValue;
    private int defaultValue;

    public int getPageSize() {
        return size;
    }
    public void setPageSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof ClassList))
            return false;
        ClassList c = (ClassList) obj;

        return this.size == c.size && this.newValue == c.newValue
                && this.defaultValue == c.defaultValue;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(size).hashCode()
                + Integer.valueOf(newValue).hashCode()
                + Integer.valueOf(defaultValue).hashCode();
    }
}