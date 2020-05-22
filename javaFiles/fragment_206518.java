class A {
    int a;
    class B {
        void process_a_in_A() {
            A.this.a++;
        }
    }
    // however, this does NOT work b/c
    // static inner classes do not have references t oouter classes
    static class C {
        void process_a_in_A() {
            // error -- class A.C is detached from its outer class A
            A.this.a++;
        }
    }
}