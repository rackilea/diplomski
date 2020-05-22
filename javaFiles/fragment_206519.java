class A {
    int a;
}

class B {
    void process_a_in_A() {
        // A here is a class name, not an object reference;
        // so A.this is meaningless in this context
        A.this.a++;
    }
}