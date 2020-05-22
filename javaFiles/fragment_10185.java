enum A {
    X(B.Z),

    A(B b) {
        System.out.println("Constructing " + name() + ": " + b);
    }
}

enum B {
    Z(A.X);

    B(A a) {
        System.out.println("Constructing " + name() + ": " + a);
    }
}