class ConcatenatedStrings implements CharSequence {
    final String s1, s2;
    public ConcatenatedString(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public char charAt(int index) {
        return index < s1.length ? s1.charAt(index) : s2.charAt(index);
    }

    // Don't forget to implement all the other mandatory methods...
}