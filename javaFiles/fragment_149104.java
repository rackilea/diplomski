public static String encodeCodepoint(int codePoint) {

    char[] chars = Character.toChars(codePoint);
    StringBuilder sb = new StringBuilder();
    for (char ch : chars) {
        sb.append(String.format("\\u%04X", (int)ch));
    }
    return sb.toString();
}