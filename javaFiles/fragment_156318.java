public static int[] computePrefix(String input) {
    int[] pi = new int[input.length()];
    int k = 0;
    for (int q = 1; q < input.length(); q++) {
        char target = input.charAt(q);
        while (k > 0 && input.charAt(k) != target) {
            k = pi[k - 1];
        }
        if (input.charAt(k) == target) {
            k++;
        }
        pi[q] = k;
    }
    return pi;
}