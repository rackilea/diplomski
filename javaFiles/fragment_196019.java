public class Test {
    int current = 10;
    int max = 100;
    public synchronized int getMax() { return max; }
    public synchronized int getCurrent() { return max; }
    public synchronized void setCurrent(int c) {
        if (c > max) throw new IllegalStateException();
        current = c;
    }
    public synchronized void setMax(int m) {
        max = m;
        if (current > m) current = m;
    }
}