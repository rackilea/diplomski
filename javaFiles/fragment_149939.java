public static String unescapeUnicode(String s) {
    StringBuilder sb = new StringBuilder();

    int oldIndex = 0;

    for (int i = 0; i + 2 < s.length(); i++) {
        if (s.substring(i, i + 2).equals("\\u")) {
            sb.append(s.substring(oldIndex, i));
            int codePoint = Integer.parseInt(s.substring(i + 2, i + 6), 16);
            sb.append(Character.toChars(codePoint));

            i += 5;
            oldIndex = i;
        }
    }

    sb.append(s.substring(oldIndex + 1, s.length()));

    return sb.toString();
}