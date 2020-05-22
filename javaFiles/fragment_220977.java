public static void main(final String[] args) {
    // You need only one scanner for both numbers. I t can be reused, so
    // declare it outside the loop.
    final Scanner scanner = new Scanner(System.in);
    // Also the number variables can be reused.
    int first, second;

    do {
        System.out.println("Give me two numbers:");

        // Scan the integers directly without parsing the lines manually.
        first = scanner.nextInt();
        second = scanner.nextInt();

        if (first == second) {
            System.out.println("The first number (" + first + ") is the same as the second (" + second + ").");
        } else {
            System.out.println("The first number (" + first + ") is different from the second (" + second + ").");
        }
    } while (10 != first);

    scanner.close();

    System.out.println("We are done here, because the first number is 10.");
}