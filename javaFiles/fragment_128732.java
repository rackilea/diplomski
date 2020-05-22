public static int swapDigitPairs(int number) {
    int result = 0;
    int place = 1;
    while (number > 9) {
        result += place * 10 * (number % 10);
        number /= 10;
        result += place * (number % 10);
        number /= 10;
        place *= 100;
    }
    return result + place * number;
}