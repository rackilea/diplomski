public static String reverse(String str) {
    char[] chars = str.toCharArray();

    for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    return new String(chars);
}