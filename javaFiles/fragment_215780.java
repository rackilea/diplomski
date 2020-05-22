public static String convert(String str) {
    StringBuilder buf = new StringBuilder();
    boolean alphabetic = false;

    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);

        if (Character.isAlphabetic(ch)) {
            if (alphabetic)
                buf.append('-');
            buf.append(Character.toLowerCase(ch) - 'a' + 1);
            alphabetic = true;
        } else {
            buf.append(ch);
            alphabetic = false;
        }
    }

    return buf.toString();
}