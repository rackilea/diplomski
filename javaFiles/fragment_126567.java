class Bubble {
    private int value;
    private int occurrences;
    private Bubble tail;

    public Bubble(int value) {
        this.value = value;
        this.occurrences = 1;
    }

    public int getValue() {
        return value;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void incrementOccurrences() {
        this.occurrences++;
    }

    public Bubble getTail() {
        return tail;
    }

    public void setTail(Bubble tail) {
        this.tail = tail;
    }
}