public static final String UTF8_BOM = "\uFEFF";

private static String removeUTF8BOM(String s) {
    if (s.startsWith(UTF8_BOM)) {
        s = s.substring(1);
    }
    return s;
}