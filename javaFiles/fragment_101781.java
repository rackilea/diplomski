public static void main(String[] args) {
    int sum = 0;
    int num = 0;
    while (num <= 1000) {
        if (num % 13 == 0 || num % 15 == 0 || num % 17 == 0) {
            if (num % 30 != 0) {
                sum = sum + num;
            }
        }
        // increase num here.
        ++num;
    }
    System.out.println("Sum = " + sum);

}