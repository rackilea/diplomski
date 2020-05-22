public static int reverseNumberWithoutDuplicate(int number) {
    if (number == Integer.MIN_VALUE) {
        // -2147483648 is a special case, not negatable.
        return -8463712;
    }
    boolean isNegative = number < 0;
    number = isNegative ? -number : number;

    BitSet usedDigits = new BitSet(10);
    int reversedNumber = 0;
    while (number != 0) {
        int digit = number % 10;
        number /= 10;
        if (!usedDigits.get(digit)) {
            usedDigits.set(digit);
            reversedNumber = 10 * reversedNumber + digit;
        }
    }
    return isNegative ? -reversedNumber : reversedNumber;
}