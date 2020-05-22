public static String split(int a, int b, int c, int d, int e) {
    StringJoiner sj = new StringJoiner(",");
    while (a > 0 || b > 0 || c > 0 || d > 0 || e > 0) {
        if (a > 0) {
            sj.add("A");
            a--;
        }
        if (b > 0) {
            sj.add("B");
            b--;
        }
        if (c > 0) {
            sj.add("C");
            c--;
        }
        if (d > 0) {
            sj.add("D");
            d--;
        }
        if (e > 0) {
            sj.add("E");
            e--;
        }
    }
    return sj.toString();
}