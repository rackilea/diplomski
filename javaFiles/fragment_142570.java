public class DynamicProxyDemo {

    private interface A {
        void methodA();
    }

    private interface B {
        void methodB();
    }

    private static class Foo implements A, B {

        public void methodA() {
            System.out.println("A");
        }

        public void methodB() {
            System.out.println("B");
        }
    }

    private DynamicProxyDemo() {}

    public static void main(final String[] args) {
        final Foo foo = new Foo(); // implements both interfaces

        // calls foo's methods, but only A methods
        final A a = DynamicProxy.createSelectiveProxy(foo, A.class);

        // calls foo's methods, but only B methods
        final B b = DynamicProxy.createSelectiveProxy(foo, B.class);

        // calls foo's methods, but A and B methods
        final A ab = DynamicProxy.createSelectiveProxy(foo, A.class, B.class);

        System.out.println("\n *** Call a method A.methodA() on proxy 'a'");
        a.methodA();

        try {
            System.out.println("\n *** Call a method B.methodB() on proxy 'a' (throws exception)");
            ((B) a).methodB();
        } catch (final Exception ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("\n *** Call a method B.methodB() on proxy 'b'");
        b.methodB();

        try {
            System.out.println("\n *** Call a method A.methodA() on proxy 'b' (throws exception)");
            ((A) b).methodA();
        } catch (final Exception ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("\n *** Call a method A.methodA() on proxy 'ab'");
        ab.methodA();

        System.out.println("\n *** Call a method B.methodB() on proxy 'ab'");
        ((B) ab).methodB();

        // ClassCastException: $Proxy0 cannot be cast to DynamicProxy$Foo
        try {
            System.out.println("\n *** Call a method 'A' of class 'Foo' on proxy 'a' (throws exception)");
            ((Foo) a).methodA();
        } catch (final Exception ex) {
            ex.printStackTrace(System.out);
        }

        // ClassCastException: $Proxy1 cannot be cast to DynamicProxy$Foo
        try {
            System.out.println("\n *** Call a method 'B' of class 'Foo' on proxy 'b' (throws exception)");
            ((Foo) b).methodB();
        } catch (final Exception ex) {
            ex.printStackTrace(System.out);
        }

        // ClassCastException: $Proxy0 cannot be cast to DynamicProxy$B
        try {
            System.out.println("\n *** Call a method B.methodB() on proxy 'a' (throws exception)");
            ((B) a).methodB();
        } catch (final Exception ex) {
            ex.printStackTrace(System.out);
        }

        // ClassCastException: $DynamicProxy1 cannot be cast to DynamicProxy$A
        try {
            System.out.println("\n *** Call a method A.methodA() on proxy 'b' (throws exception)");
            ((A) b).methodA();
        } catch (final Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}