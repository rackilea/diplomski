public static int ackermann(int m, int n) {
    if (m < 0 || n < 0) {
        throw new IllegalArgumentException("Non-negative args only!");
    }

    if (m == 0) {
        return n + 1;
    } else if (n == 0) {
        return ackermann(m-1, 1); // Corrected!
    } else {
        // perforce (m > 0) && (n > 0)
        return ackermann(m-1, ackermann(m,n-1));
    }
}