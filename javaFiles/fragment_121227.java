class A {
    static void x() {
        System.out.println("A");
    }
}

class B extends A {
    static void x() {
        System.out.println("B");
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        A a = new B();
        a.x();
    }
}