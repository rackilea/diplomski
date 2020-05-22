public static String split(int a, int b, int c, int d, int e) {
    StringBuilder sb = new StringBuilder();
    while (a > 0 || b > 0 || c > 0 || d > 0 || e > 0) {
        if (a > 0) {
            sb.append(",A");
            a--;
        }
        if (b > 0) {
            sb.append(",B");
            b--;
        }
        if (c > 0) {
            sb.append(",C");
            c--;
        }
        if (d > 0) {
            sb.append(",D");
            d--;
        }
        if (e > 0) {
            sb.append(",E");
            e--;
        }
    }
    if (sb.length() > 0) {
        sb.deleteCharAt(0);
    }
    return sb.toString();
}