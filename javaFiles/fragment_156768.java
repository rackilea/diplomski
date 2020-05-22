public class IndexedEntry<T extends Comparable<T>>
    implements Comparable<IndexedEntry<T>> {

    private final Integer index;

    private final T entry;

    public IndexedEntry(Integer index, T entry) {
        this.index = index;
        this.entry = entry;
    }

    public Integer getIndex() {
        return this.index;
    }

    public T getEntry() {
        return this.entry;
    }

    @Override
    public int compareTo(IndexedEntry<T> other) {
        int byEntry = this.getEntry().compareTo(other.getEntry());
        if (byEntry == 0) {
            return this.getIndex().compareTo(other.getIndex());
        }
        return byEntry;
    }

    @Override
    public String toString() {
        return "(" + this.entry + ", " + this.index + ")";
    }
}