public static String[] ngrams(String str, int length) {
    char[] chars = str.toCharArray();
    final int resultCount = chars.length - length + 1;
    String[] result = new String[resultCount];
    for (int i = 0; i < resultCount; i++) {
        result[i] = new String(chars, i, length);
    }
    return result;
}