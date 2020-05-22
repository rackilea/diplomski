class OperatorData implements Comparable<OperatorData> {
    private String token;
    private int level;

    // constructor etc.

    @Override
    public int compareTo(OperatorData other) {
        return Integer.compare(level, other.level);
    }
}