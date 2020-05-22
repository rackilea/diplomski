public static int persistence(int num) {
    int numberOfTimes = 0;
    int temp;
    while (num > 9) {
        temp = 1;
        while (num > 0) {
            temp *= num % 10;
            num /= 10;
        }
        num = temp;
        numberOfTimes++;
    }
    return numberOfTimes;
}