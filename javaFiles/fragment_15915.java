class Wrapper {
    int n;
    public Wrapper(int k) { n = k; }
    public String toString() { return ""+n;}
    public static Wrapper valueOf(int k) { return new Wrapper(k); }
}