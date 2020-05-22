// Fake constructor
public static A new_A(int i, double v) {
    A x = new A();
    x.i = i;
    x.v = v;
    return x;
}

A[] x = new A[]{new_A(1, 2.5), ... };