class X {
    public static void test() {
        // all of these statements fail ...
        A.B b = new A.B();
        b.foo = 1; b.bar = 1; 
        b.test();
        A.P p = new A.P();
        p.foo = 1; p.bar = 1;  
        p.test();
    }

}