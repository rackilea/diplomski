private static int[] getDigitCount(int n) {
    int[] digitCount = new int[10]; // 10 distinct digits
    Arrays.fill(digitCount, 0); // start at 0 occurrence for each digit

    // special case 0
    if (n == 0) {
        digitCount[0] = 1; // 1 occurrence for digit '0'
        return digitCount;
    }

    // fill digitCount with the number of occurrences of each digit in n
    int digit;
    while(n > 0) {
        digit = n % 10; // current last digit of n
        digitCount[digit]++; // increments the number of occurrences for that digit
        n /= 10; // shifts the decimal number n to the right (last digit disappears)
    }
    return digitCount;
}