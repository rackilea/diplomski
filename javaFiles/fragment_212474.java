public class Counter {
    private int count = 0;

    public void add(int value) {
        count = count + value;
    }

    @Override
    public String toString() {
        return super.toString() + "[count=" + count + "]";
    }
}