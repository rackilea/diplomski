public class Test {
    private int a1;
    private long a2;
    private double a3[];

    public Test(final int a1, final long a2, final double[] a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public int getSize() {
        return 4 + 8 + (a3.length * 8);
    }
}