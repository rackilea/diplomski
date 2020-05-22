private static boolean endsWith(char ch, StringBuilder buf) {
    return buf.length() > 0 && buf.charAt(buf.length() - 1) == ch;
}

private static void removeLastChar(StringBuilder buf) {
    buf.setLength(buf.length() - 1);
}