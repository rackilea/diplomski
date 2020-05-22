public class MyClass implements Comparable<MyClass> {
    private int x, p;

    /*
     * x: Contents
     * p: Priority
     */
    public MyClass(int x, int p) {
        this.x = x;
        this.p = p;
    }

    @override
    public int compareTo(MyClass o) {
        return this.p - o.p;
    }

    public int getX() {
        return x;
    }
}