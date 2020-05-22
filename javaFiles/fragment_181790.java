public static String quote(String s) {
    return new StringBuilder()
        .append('\'')
        .append(s)
        .append('\'')
        .toString();
}

public static void main(String[] args) {
    String x = "ABC";
    String quotedX = quote(x);
    System.out.println(quotedX);
}