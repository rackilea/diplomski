static int sumString(final String str) {
    int sum = 0;
    for (char ch : str.toCharArray()) {
        if (ch >= 'A' && ch <= 'Z') { // <-- validate input
            sum += 1 + ch - 'A';      // <-- 'A' - 'A' == 0, 'B' - 'A' == 1, etc.
        }
    }
    return sum;
}