public class C {
    private B b;

    public C (B b) {
        this.b = b;
    }

    public boolean isLargerThanTen() {
        return b.getSomeCalculation() > 10;
    }
}