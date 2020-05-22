public class A {

    public A fun() {
        System.out.println("A");
        return new AA();
    }

    private class AA extends A {
        @Override
        public A fun() {
            System.out.println("AA");
            return this;
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.fun();
        a.fun().fun();
        a.fun().fun().fun();
    }
}