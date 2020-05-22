public int VerifyKaprekarTheorem(int m) {
    if (m <= 1000 || m > 9999) {
        return -1;
    }
    int count = 0;
    while (true) {
        int Max = largestNumber(m);
        int Min = smallestNumber(m);
        count++;
        m = Max - Min;
        if (m == 6174) {
            break;
        }
    }
    return count;
}
private static int largestNumber(int input) {
    int[] numbers = new int[10];
    for (int i = input; i != 0; i /= 10) {
        numbers[i % 10]++;
    }
    int counter = 0;
    int result = 0;
    for (int i = 0; i < 10; counter += numbers[i++]) {
        result += (int) ((Math.pow(10, numbers[i]) * i - 1) / 9) * Math.pow(10, counter);
    }
    return result;
}

private static int smallestNumber(int input) {
    int[] numbers = new int[10];
    for (int i = input; i != 0; i /= 10) {
        numbers[i % 10]++;
    }
    int counter = 0;
    int result = 0;
    for (int i = 9; i >= 0; counter += numbers[i--]) {
        result += (int) ((Math.pow(10, numbers[i]) * i - 1) / 9) * Math.pow(10, counter);
    }
    return result;
}