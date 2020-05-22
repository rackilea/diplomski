public static int getDigitSum(int number) {
    int total = 0;
    while (number > 0) {
        total += number % 10;
        number /= 10;
    }
    return total;
}

public static int getSum(final int number) {
    if (number <= 1) {
        return 1;
    } else {
        final int sum = getSum(number - 1); // a(n-1) from formula
        return sum + getDigitSum(sum); // sum of digits of a(n-1) from formula
    }
}