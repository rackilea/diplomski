public class Pair<P, Q> {

    // Exposing p & q directly for simplicity. They are final so this is safe.

    public final P p;
    public final Q q;

    public Pair(P p, Q q) {
        this.p = p;
        this.q = q;
    }