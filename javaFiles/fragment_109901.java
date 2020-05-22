static Callable<Object> gen(int i) {
    class X {
        int x = i;
        public String toString() { return "" + x; }
    }
    X x=new X();
    …