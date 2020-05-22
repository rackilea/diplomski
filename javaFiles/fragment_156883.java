public static String remove(String str) {
    StringBuilder buf = new StringBuilder(str.length());

    for (int i = 1; i <= str.length(); i++)
        if (str.charAt(i - 1) == ' ' || str.charAt(i - 1) == '.' || i % 5 != 0)
            buf.append(str.charAt(i - 1));

    return buf.toString();
}