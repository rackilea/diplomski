public static String decode(String message) {
    StringBuilder b = new StringBuilder(message).reverse();
    StringBuilder o = new StringBuilder();
    for (int i = 0; i < b.length(); i++) {
        char c = b.charAt(i);
        c -= i;
        c /= 2;
        o.append(c);
    }
    return o.toString();
}