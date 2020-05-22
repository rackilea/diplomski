class Gjorgji {
    boolean a;
    boolean b;
    boolean c;
    int x;
    int y;

    // EDIT: I almost forgot a VERY important rule...
    // WHEN YOU OVERRIDE hashCode, OVERRIDE EQUALS (and vice versa)
    public int equals(Object o) {
        if(!(o instanceof Gjorgji) return false;
        Gjorgji g = (Gjorgji)o;
        return a == g.a && b == g.b && c == g.c && x == g.x && y == g.y;

    }

    public int hashCode() {
        int hash = x ^ y;
        hash *= a ? 31 : 17; // pick some small primes
        hash *= b ? 13 : 19;
        hash *= c ? 11 : 29;
        return hash;
    }

}