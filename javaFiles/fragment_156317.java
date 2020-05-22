public static int[] computePrefix(String input) {
    int[] pi = new int[input.length()];
    int k = 0;
    for (int q = 2; q <= input.length(); q++) {
        char target = input.charAt(q - 1);
        while (k > 0 && input.charAt(k + 1 - 1) != target) {
            k = pi[k - 1];
        }
        if (input.charAt(k + 1 - 1) == target) {
            k++;
        }
        pi[q - 1] = k;
    }
    return pi;
}