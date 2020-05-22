public class Test {
    long n = 0;

    static class A {
        // Not allowed.
        long x = n;
    }

    class B {
        // Allowed.
        long x = n;
    }

}