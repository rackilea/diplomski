public static int add(int number1, int number2) {
    int sum = 0;
    for (int i = number1; i <= number2; i++) {
        if (i % 2 == 0)
            sum += i;
    }
    return sum;
}