public static boolean isPerfectNumber(int number) {
    return number >= 1 && IntStream //
            .range(1, number) //
            .filter(i -> number % i == 0) //
            .sum() == number;
}