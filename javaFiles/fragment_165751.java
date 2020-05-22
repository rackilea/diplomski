public class C {
    private int x = 5;
    private String y;

    public C(int x) {
        this.x = x;
        endConstructor();
    }

    public C(String x) {
        this.x = x.length;
        endConstructor();
    }

    private void endConstructor() {
        y = x + "!";
    }
}