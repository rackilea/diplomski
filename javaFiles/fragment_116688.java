public class WordFrequency implements Comparable<WordFrequency> {
    private String word;
    private Integer frequency;

    public WordFrequency(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    // descending order
    @Override
    public int compareTo(WordFrequency o) {
        return o.getFrequency() - this.getFrequency();
    }

    public Integer getFrequency() {
        return this.frequency;
    }

    @Override
    public String toString() {
        return word + ": " + frequency;
    }
}