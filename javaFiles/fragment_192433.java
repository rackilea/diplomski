int number;
do {
    System.out.println("Write a number between (0-" + length + "):");
    number = input.nextInt();
    if (number < 0) {
        System.out.printf("%d is too low%n", number);
    } else if (number > length) {
        System.out.printf("%d is too high%n", number);
    }
} while (number < 0 || number > length);
check(arr, number);