public static int sumForOddNumbers(int total) {
    int sum = 0;

    for(int i = 0, odd = 1; i < total; i++, odd += 2) {
        sum += odd;
    }

    return sum;
}