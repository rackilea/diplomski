public class Pair {
    private int a;
    private int b;

    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", a, b);
    }
}