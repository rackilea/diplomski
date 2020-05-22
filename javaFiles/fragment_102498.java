private static boolean isRepresentable(int n, int[] nbAllowed) {
    int[] digitCount = getDigitCount(n);

    // check if each digit is available enough times
    for (int d = 0; d < nbAllowed.length; d++) {
        if (nbAllowed[d] < digitCount[d]) {
            return false; // not enough d digits to represent n
        }
    }
    return true; // enough of all digits
}