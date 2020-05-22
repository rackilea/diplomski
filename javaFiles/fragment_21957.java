class BoundedCounter {
    private int value;
    private int upperLimit;

    public BoundedCounter(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public void next() {
        // when reach the upperLimit, the next value should be 0
        // so >= is not needed, just == will do
        this.value = this.value == this.upperLimit ? 0 : this.value+1;
    }

    public String toString() {
        // using smarter approach to pad with zeros :)
        return String.format("%02d", value);
    }

    public int getValue() {
        // this method should only return the value, not change it in any way
        return this.value;
    }
}