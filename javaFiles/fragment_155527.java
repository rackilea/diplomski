static void print(double d) {
    System.out.printf("%016x\n", Double.doubleToLongBits(d));
}

public static void main(String args[]) {
    double a = 0.5;
    double b = 0.49999999999999994;

    print(a);      // 3fe0000000000000
    print(b);      // 3fdfffffffffffff
    print(a+b);    // 3ff0000000000000
    print(1.0);    // 3ff0000000000000
}