public static String reverse(String str) {
    StringBuilder buf = new StringBuilder(str.length());

    for (int i = str.length() - 1; i >= 0; i--)
        buf.append(str.charAt(i));

    return buf.toString();
}