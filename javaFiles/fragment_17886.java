public class Qu {
    private final byte[] b;
    private final int s;

    public Qu(byte[] b,int s) {
        this.b = Arrays.copyOf(b, b.length);
        this.s = s;
    } 

    public String toString(){
        return s+"";
    }
}