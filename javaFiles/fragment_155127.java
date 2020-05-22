public class A {
    private static class B {
        public int foo; // accessible in A and P
        private int bar; // accessible in A and P   
        public static void test(){
            P p = new P();
            p.foo = 1; p.bar = 1;
        }
    }
    private static class P {
        public int foo; // accessible in A and B
        private int bar; // accessible in A and B   
        public static void test(){
            B b = new B();
            b.foo = 1; b.bar = 1;
        }
    }
    public static void test(){
        B b = new B();
        b.foo = 1; b.bar = 1;
        P p = new P();
        p.foo = 1; p.bar = 1;       
    }
}