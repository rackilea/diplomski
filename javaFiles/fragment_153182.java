public class Entry implements Comparable<Entry> {
    private String key;
    private int value;

    public Entry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    // getters

    @Override
    public int compareTo(Entry other) {
        return this.getKey().compareTo(other.getKey());
    }
}