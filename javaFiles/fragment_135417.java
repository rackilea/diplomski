private static final Equivalence<char[]> CHAR_ARRAY_EQUIV = new Equivalence<char[]>(){

    @Override
    protected boolean doEquivalent(char[] a, char[] b) {
        return Arrays.equals(a, b);
    }

    @Override
    protected int doHash(char[] chars) {
        return Arrays.hashCode(chars);
    }
};