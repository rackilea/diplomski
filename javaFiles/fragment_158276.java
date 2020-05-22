class A {
    public void print(Object o) {
        System.out.println("A.print " + o);
    }

    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        b.print("test b");
        a.print("test a");
        ((A) b).print("test a or b");
    }
}

class B extends A {
    public void print(Object o) {
        System.out.println("B.print " + o);
    }
}