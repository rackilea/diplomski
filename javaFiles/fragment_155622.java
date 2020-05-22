public static int palindromeCount(int start, int finish) {
    int k = start;
    int returnVal = 0;
    while (k <= finish) { // Changed to <= to consider "finish" too
        int temp = k;
        int r = 0;
        while (temp > 0) {
            r = 10 * r + temp % 10;
            temp = temp / 10;
        }
        if (r == k) {
            returnVal++;
        }
        k++;
    }
    return returnVal;
}