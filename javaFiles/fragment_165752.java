public class C {
    private int x = 5;
    private String y;

    public C(int x) {
        this.x = x;
        y = x + "!";
    }

    public C(String x) {
        this(x.length);
    }
}