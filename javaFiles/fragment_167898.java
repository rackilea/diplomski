private static Pattern nines = Pattern.compile("9+");

/** Return 10^m for m=0,1,...,18 */
private long pow10(int m) {
    // implement with either pow(10, m) or a switch statement
}

public long f(String n) {
    int Z = Integer.parseInt(n.substring(0, 1));
    int nlen = n.length();
    if (nlen == 1) {
        return Z > 0 ? 1 : 0;
    }
    if (nines.matcher(n).matches()) {
        return nlen * pow10(nlen - 1);
    }
    String m_digits = n.substring(1);
    int m = nlen - 1;
    return Z * m * pow10(m - 1) + f_impl(m_digits)
        + (Z > 1 ? pow10(m) : Z * (Long.parseLong(m_digits) + 1));
}