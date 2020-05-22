class MyClass {
    String str;
    Integer intgr;
    /**
     * Returns the relationship between this and another MyClass instance.
     * The relationship can be one of three values:
     * <pre>
     *   -1 - This object should be discarded and other kept
     *    0 - There is no relationship between this and other
     *    1 - This object should be kept and other discarded
     * </pre>
     *
     * @param other The other instance to evaluate
     *
     * @return 0 if there is no relationship.
     */
    public int relationTo(MyClass other) {
        final String myPrefix = str.substring(0, str.length() - 1);
        final String otherPrefix = other.str.substring(0, other.str.length() - 1);
        if (myPrefix.equals(otherPrefix)) {
            return intgr < other.intgr ? -1 : 1;
        } else {
            return 0;
        }
    }
}