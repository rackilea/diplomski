private static int[] getEveryOtherDigit(int n) {
    String s = Integer.toString(n);
    int[] result = new int[s.length() / 2];
    for (int i = 1, j = 0; i < s.length(); i += 2, j++)
        result[j] = s.charAt(i) - '0';
    return result;
}