class A {
    int i;
}

class B {
    A a = new A();
}

class Main {
    public static void main(String[] args) {
        B b = new B();
        // point 1
        b = null;
        // point 2
    }
}