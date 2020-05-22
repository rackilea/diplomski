public final class DecIterator implements Iterator<Integer> {
    private final int length;
    private int firstDigit = 1;

    public DecIterator(int length) {
        this.length = length;
    }
    @Override
    public boolean hasNext() {
        return (this.firstDigit + this.length <= 10);
    }
    @Override
    public Integer next() throws NoSuchElementException {
        if (! hasNext())
            throw new NoSuchElementException();
        int value = 0;
        for (int i = 0; i < this.length; i++)
            value = value * 10 + this.firstDigit + i;
        this.firstDigit++;
        return value;
    }
}