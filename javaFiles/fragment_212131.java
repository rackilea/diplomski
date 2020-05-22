public class Number{
    private Number left;
    private int mod;
    public Number(int modulus, Number left) {
        mod = modulus;
        this.left = left;
    }
}