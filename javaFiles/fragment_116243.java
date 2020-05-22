static bool isPalindrome (int n1, int n2) {
    return getReverseInteger(n1) == n2;
}

static int getReverseInteger (int n) {
    int nReversed = 0;
    while (n > 0) {
      int digit = n % 10;
      nReversed = nReversed * 10 + digit;
      n = (n - digit) / 10;
    }
    return nReversed;
}