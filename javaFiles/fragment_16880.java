public static String[] ngramsSubstring(String str, int length) {
    final int resultCount = str.length() - length + 1;
    String[] result = new String[resultCount];
    for (int i = 0; i < resultCount; i++) {
        result[i] = str.substring(i, i+length);
    }
    return result;
}