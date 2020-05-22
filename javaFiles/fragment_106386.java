public static int oddDigitCounter(int number) {
    if (number==0) {
        return 0;
    }
    return (number&1) + oddDigitCounter(number/10);
}