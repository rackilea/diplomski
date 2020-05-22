public class DoubleKey<K extends Comparable<K>, J extends Comparable<J>>
        implements Comparable<DoubleKey<K, J>> {

    private K key1;
    private J key2;

    public DoubleKey(K key1, J key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public K getFirstKey() {
        return this.key1;
    }

    public J getSecondKey() {
        return this.key2;
    }

    public int compareTo(DoubleKey<K, J> that) {

        int cmp = this.getFirstKey().compareTo(that.getFirstKey());
        if (cmp == 0)
            cmp = this.getSecondKey().compareTo(that.getSecondKey());
        return cmp;
    }
}