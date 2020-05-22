private static int sumCuriousNumbers(int n) {
    int sum = 0;
    for (int i = 10; i <= n; i++)
        if (isCuriousNumber(i))
            sum += i;
    return sum;
}
private static boolean isCuriousNumber(int number) {
    int sum = 0;
    for (int i = number; i > 0; i /= 10)
        sum += factorial(i % 10);
    return (sum % number == 0);
}
private static int factorial(int n) {
    int f = 1;
    for (int i = 1; i <= n; i++)
        f *= i;
    return f;
}