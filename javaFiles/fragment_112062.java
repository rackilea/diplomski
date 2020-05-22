public int hashCode() {       
    // assume that both a and b are sorted       
    return a[0] + powerOf52(a[1], 1) + powerOf52(b[0], 2) + powerOf52(b[1], 3) + powerOf52(b[2], 4);
}

public static int powerOf52(byte b, int power) {
    int result = b;
    for (int i = 0; i < power; i++) {
        result *= 52;
    }
    return result;
}