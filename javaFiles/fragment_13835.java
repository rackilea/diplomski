private static class ValueWrapper implements Comparable<ValueWrapper> {
    private final String value1;
    private final String value2;
    public ValueWrapper(String value1, String value2) { 
        this.value1 = value1;
        this.value2 = value2;
    }
    public int compareTo(ValueWrapper other) {
        // we are comparing the value2 fields here
        return this.value2.compareTo(other.value2);
    }
}