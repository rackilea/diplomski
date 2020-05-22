public class run {
    public static void main(String[] argv) {
        System.loadLibrary("test");
        A a = test(); 
        System.out.println("A.v = " + a.getV());
    }

    private static A test() {
        B b = new B();
        A result = b.getA();
        System.out.println("A.v = " + b.test() + " (test)");
        b.counter();
        System.out.println("A.v = " + result.getV());
        return result;
    }
}