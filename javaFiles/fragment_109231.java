class WordFrequency implements Comparable<WordFrequency> {
    private final String word;
    private final int frequency;

    public Word(final String word, final int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public int compare(final WordFrequency other) {
        if(other == null) {
            return -1;
        } else {
            return Integer.compare(frequency, other.frequency);
        }
    }
}