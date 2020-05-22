public class Main {

    public static class A{};
    public static class B extends A{};
    public static class C extends A{};
    public static class Runner{
        public static void Run( A a ){System.out.println("A");};
        public static void Run( B b ){System.out.println("B");};
        public static void Run( C c ){System.out.println("C");};
    }

    static <T extends A> void SomeRandomCall( T x ){
         Runner.Run( x );
    }

    public static void main(String[] args) {
        B b = new B();
        new Runner().Run( b );
    }
}