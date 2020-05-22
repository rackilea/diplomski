class Pair {
    int a;
    int b;
    Pair(int a, int b) { this.a = a; this.b = b; }
    public boolean equals(Object o) {
        if(o instanceof Pair) {
            Pair p = (Pair)o;
            if(a == p.a && b == p.b) return true;
            // check reverse, as per comment from @Chance
            if(a == p.b && b == p.a) return true;
        }
        return false;
    }
    // poor hashcode, for sure, but we need hash(a,b) == hash(b,a)...
    public int hashCode() { return a ^ b; }
}