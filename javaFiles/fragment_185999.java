public static String swapPairs(String input) {
    char[] chars = input.toCharArray();
    for (int i = 0; i < chars.length - 1; i += 2) {
        char tmp = chars[i];
        chars[i] = chars[i + 1];
        chars[i + 1] = tmp;
    }
    return new String(chars);
}