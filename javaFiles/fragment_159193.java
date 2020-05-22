class Int {
    private int wrapped;

    public Int(int wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String toString() {
        return Integer.toString(wrapped);
    }

    public Int plus(Int other) {
        int sum = this.wrapped + other.wrapped;
        return new Int(sum);
    }
}