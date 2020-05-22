public class ConnectionMap extends Connection {

    private int n;

    public ConnectionMap (final int n) {
        super(n);

        //Here, n is recognized from the superclass and it simply works
        if (n < 0) {  
            throw new IllegalArgumentException("Error.");
        }
        this.n = n;
    }

    @Override
    public int test() {
        int c = this.n;
        ...
    }
}