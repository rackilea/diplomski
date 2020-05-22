private static int stripTrailingZeros(int number) {
    while (number != 0 && number % 10 == 0) {
        number /= 10;
    }
    return number;
}