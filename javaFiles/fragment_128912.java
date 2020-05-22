public class forTest implements Comparable<forTest> {
    @Override
    public int compareTo(forTest other) {
        return this.value.compareTo(other.value);
    }
    ...
}