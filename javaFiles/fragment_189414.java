public static int ascii(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        sb.append(Integer.toString(c));
    }
    return Integer.parseInt(sb.toString());
}

public static void main(String[] args) {
    String[] str = { "b78", "c&3", "a00", "a01", "zz9" };
    for (String q : str) {
        int c = ascii(q);
        System.out.printf("%s %d%n", q, c);
    }
}