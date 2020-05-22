long addSquaresOfDigits(int number) {
    long result = 0;
    int tmp = 0;
    while(number > 0) {
        tmp = number % 10;
        result += tmp * tmp;
        number /= 10;
    }
    return result;
}